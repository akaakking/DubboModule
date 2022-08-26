# Dubbo API 暴露与访问控制

## 1.0 项目介绍

所谓面向对象，在我看来就是我们为了化抽象为具象从而增添软件的可维护性，采取了这样的手段，将抽象的程序世界中的一些功能和数据的集合投影在现实世界。以类为一个基本容器，来封装数据和功能单元，容器不同，数据不同进而产生不同的对象，对象之间通过暴露的接口交流，进而维持了程序的运行，这时候每个对象对于内部实现的隐藏以及外部接口暴露的控制就显得十分重要。

java提供了四种访问修饰符，让我们对容器中的数据功能单元的可见性进行访问控制。

| 访问修饰符 | 类内 | 包内 | 子类内 | 无限制 |
| ---------- | ---- | ---- | ------ | ------ |
| public     | 可见 | 可见 | 可见   | 是     |
| protect    | 可见 | 可见 | 可见   |        |
| default    | 可见 | 可见 |        |        |
| private    | 可见 |      |        |        |

如果以一个类为基本容器，那么public和private权限就已经完全够用了。但是为了扩大控制范围在此基础上我们又增加了protect和default修饰符，让我们可以最大以包为边界进行访问控制。

但是以包为权限的访问控制能够满足面向对象的全部需要吗？

是不能的，因为包的概念还不够大，我们在现实世界中为一组数据和功能的集合找到类作为封装依据的边界，虽然可以以一个包作为一些类的集合，来提供一组服务，依据包我们也可以根据现有修饰符确定一个边界，但是包的概念还是太小了，我们不可能将一个模块的所有类放在同一个包下这是一个现实问题毕竟dubbo的包结构是这样，其中每个包点开还有无数复杂结构。

![image-20220821161339760](./pic/image-20220821161339760.png)



在java中jar包是最接近一个模块的概念的，一个模块可以看作一个服务的基本单位或者一组服务的集合，比如引入dubbo.jar，我们就可以使用rpc服务，引入fastjson.jar我们可以使用序列化服务

那么既然确定了暴露边界---jar包，这时我们就需要考虑以jar包为单位对dubbo进行访问控制。

现在给出了两种方案，利用java9带来的模块化特性，和jar嵌套迷惑类加载器。



## 2. Java9 Module方案



```java
|- Dubbo
    |-org
    	|-apache
    		|-dubbo
    			|-config
    				|-A.java
                        |.......
    			|-common
                        |B.java
                        |.....
```

这是一个java9之前一个jar包的目录结构，与此不同的是java9 jar包的根目录下多了一个模块描述化描述符module-info.java

```java
|- Dubbo
    |-org
    	|-apache
    		|-dubbo
    			|-config
    				|-A.java
                        |.......
    			|-common
                        |B.java
                        |.....
    |-module-info.java
```

在这个描述符中我们可以声明对其他包的依赖，还可以选择要导出哪些包。类似于这样

```java
module dubbo {
    exports org.apache.dubbo.config
}
```

这样我们就导出了config包，可以看到的是我们并没有导出common包。那么对于common包中public的类，其他包就无法访问到。

那么按理来说，我们只需要遵循这种规则做一个模块化描述符就行了，但事情往往不是那么简单的。

我们最初是想要做到像jdk9的那种效果，就是严格按照模块化来做，jdk9确实也达到了封装的效果，就是我们去访问一个未导出的包时会编译报错。

但后来发现，我们的包做了模块化后，外边还是能够访问到，并没有达到预想的效果。。。。。

后来查阅大量资料，我发现原来是这样的。

 为了保证原来的







## 3. jar嵌套迷惑类加载器

### 3.1 理论依据

// todo 介绍类加载机制

我们利用AppClassLoader不能加载标准目录格式的jar包的特点来向AppClassLoader隐藏我们的类，就是我们可以将我们的jar包做成这样

```java
|- dubbo.jar
    |- dubboInternal.jar
```



这样用户就加载不到dubboInternal.jar中的类了，我试了一下，打包成这个样子后，确实引用不到内部的类了，体现在

1.   IDEA保红
2.   编译报错

说明这样打包确实让用户加载不到嵌套jar里边的类。

那么我们可以自定义一个类加载器，去加载嵌套jar的类，过程是这样的，自定义类加载器，在初始化的时候，找到dubbo.jar包，将他解压到一个临时文件，这时候我们就可以通过自定义类加载器去加载dubboInternal.jar,是没有问题的。



### 3.2 验证理论

我们以这个demo为例

```java
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ServiceConfig<DemoServiceImpl> serviceConfig = new ServiceConfig();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(new DemoServiceImpl());
        System.out.println(ApplicationConfig.class.getClassLoader());
        serviceConfig.setApplication(new ApplicationConfig("dubbo-demo-api-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setMetadataReportConfig(new MetadataReportConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.export();

        System.out.println("服务已开启");
        new CountDownLatch(1).await();
    }
}
```

当我们引入的pom是现有的dubbo时。

```java
<dependency>
	<groupId>org.apache.dubbo</groupId>
	<artifactId>dubbo</artifactId>
	<version>3.0.9-SNAPSHOT</version>
</dependency>
```

开启zookeeper,启动程序吗，成功启动服务，并接受了一个consumer的请求

这时候我们试着看能不能在不改变现有demo源码的情况下，将pom依赖改为我们制作的Dubbo的jar包后，能不能正常运行。



设计是这样的

1.   我们 封装过的jar包的目录结构如下

     ```java
     |-dubbo.jar
     -----|dubboInternal.jar   // dubbo原本的jar包
     -----|-org
     ----------|-apache
     ---------------|-dubbo
     -------------------|-config
     -----------------------|-ApplictionConfig.class
     -----------------------|-MetadataReportConfig.class
     -----------------------|- RegistryConfig.class
     -----------------------|-ServiceConfig.class
     -------------------|-compiler
     -----------------------|-DubboClassLoader.class
     ```

     外边放的是要暴露给用户的类，但这里要注意的是ApplicationConfig.class这些类，以及不是原本内部的类了，因为如果要将原本类原封不动的搬到外边的话，会牵扯着暴露许多内部不需要暴露的类也得暴露，所以我们在外部暴露的类其实可以看作是内部类的一个代理。

     例如ApplicationConfig，可以看到他没有实际功能只是内部实现的一个代理。

     ```java
     public class ApplicationConfig {
         private Object instance;
     
         public ApplicationConfig(String arg) {
             this.instance = DubboClassLoader.getInstance(ApplicationConfig.class, arg);
         }
     
         public Object getInstance() {
             return this.instance;
         }
     }
     ```

     

     但由于各个类的包没变化，所以相应的import语句也不会发生变化。方法的签名也都做成和原来样子一样。就不用修改原有的源码。

2.   第二步就是去设计那些代理类。因为其他几个差不多，ServiceConfig相对来说最为复杂，所以我们只把他代码展示出来。(相应的全部源码在readme的同级目录下的reflect包里）

     ```java
     public class ServiceConfig {
         private Object instance;
         private Class clazz;
     
         public ServiceConfig() {
     
             this.instance = DubboClassLoader.getInstance(ServiceConfig.class);
             try {
                 this.clazz = DubboClassLoader.getKlass(ServiceConfig.class);
             } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }
     
     
             System.out.println("instanceis " + this.instance);
         }
     
         public void setInterface(Class<?> clazz) {
             try {
                 Method method = this.clazz.getMethod("setInterface", Class.class);
                 method.invoke(this.instance, clazz);
             } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var3) {
                 var3.printStackTrace();
             }
     
         }
     
         public void setRef(Object ref) {
             try {
                 Method method = this.clazz.getMethod("setRef", Object.class);
                 method.invoke(this.instance, ref);
             } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var3) {
                 var3.printStackTrace();
             }
     
         }
     
      。。。。。。。。。。。。。。。。。。。。。。。。
     
         public void setMetadataReportConfig(MetadataReportConfig metadataReportConfig) {
             Method method = null;
     
             try {
                 method = this.clazz.getMethod("setMetadataReportConfig", DubboClassLoader.getKlass(MetadataReportConfig.class));
                 method.invoke(this.instance, metadataReportConfig.getInstance());
             } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException var4) {
                 var4.printStackTrace();
             }
     
         }
     
         public void export() {
             try {
                 Method method = this.clazz.getMethod("export");
                 method.invoke(this.instance);
             } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var2) {
                 var2.printStackTrace();
             }
     
         }
     }
     ```

3.   第三步就是要去设计我们的类加载器DubboClassLoader

     首先他会在静态块想办法从classpath中找到dubbo.jar并解压缩到在一个系统的临时文件中

     ```java
         static {
             File file = UnZipJAR();
             try {
                 URL url = file.toURL();
                 classLoader = new InternalURLClassLoader(new URL[]{url});
                 Thread.currentThread().setContextClassLoader(classLoader);
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             }
         }
     ```

     之后用解压缩出的dubboInternal.jar去初始化InternalURLClassLoader。

     我们的InternalURLClassLoader的设计是这样的

     为了保证我们的类加载器加载的是dubboInternal中的类而不是外部的同名代理类

     我们让他继承了URLClassLoader并覆盖了他的loadclass方法,加载之前对其做判断，如果包名以org,apache.dubbo或com.alibaba.dubbo开头那么用DubboClassLoader从内部加载否则让AppClassLoader从classpath上加载。

     从而打破双亲委派机制

     ```java
             @Override
             public Class<?> loadClass(String name) throws ClassNotFoundException {
                 synchronized (this.getClassLoadingLock(name)) {
                     Class<?> c = this.findLoadedClass(name);
                     if (c == null) {
                         if ((name.startsWith("org.apache.dubbo") || name.startsWith("com.alibaba.dubbo"))) {
                             c = findClass(name);
                         } else {
                             c = getParent().loadClass(name);
                         }
                     }
                     return c;
                 }
             }
     ```

     

     这样我们DubboClassLoader就能够加载到dubboInternal.jar中的实例.我们再为其设计几个友好的访问接口就ok了。

     但是跑起来的时候出现了bug,最后定位到是javassist相关出现了问题。javassist在动态生成代码的时候会将内部代码和用户代码掺杂在一起，而我们的AppClassLoader无法加载内部代码所以出现了错误。虽然在fall down 到 jdkProxy后可以正常运转，但是jdkproxy相对来说还是慢，所以仔细研究了这个问题，决定将DC这个类挪出去，因为就是他混在了用户代码里，要挪出DC牵扯着也挪出了以下几个类。（也修改了相应的部分源码），在类加载器做判断时也将这几个类排除在外让他们走AppClassLoader

     ![image-20220826203437743](/home/wfh/.config/Typora/typora-user-images/image-20220826203437743.png)

之后再重新启动demo,成功启动。并成功接受了一个用户的请求。

反射这种方案好在不需要修改现在的代码，但是考虑到要减少反射这种hack代码的使用，我们决定用接口方案替代反射方案，最后折腾了半天接口方案的demo也成功跑通了。

接口方案思路如下

### 3.3设计方案

假如说我们要暴露ServiceConfig这个类

```java

public class ServiceConfig<T> extends ServiceConfigBase<T> {
	......
    public void export() {
        .....
    }
}
```

我们首先创建一个ServiceConfigInterface,并让ServiceConfig实现

```java
public interface ServiceConfigInterface<T> {
    .....
    public void export() {
        
    }
}
public class ServiceConfig<T> extends ServiceConfigBase<T> implments ServiceConfigInterface<T>{
	......
    public void export() {
        .....
    }
}
```

这样的话只要我们在外部，再创建一个ServiceConfigInterface的子类并让他和ServiceConfig，叫一样的名字就行了

目录结构是这样的

![image-20220826204959955](/home/wfh/.config/Typora/typora-user-images/image-20220826204959955.png)

那么我们要做的事情实际上就很清晰了。

1.   编译前期代码生成 interface
2.   编译前期代码生成 class
3.   编译前期修改源码让其implments与其相应的接口
4.   编译前期修改源码修改方法签名
5.   编译前期修改源码修改对返回值发生变化的方法的调用做强制类型转换。
6.   集成入maven

### 3.5 设计代码生成代码

代码生成首先是考虑使用Qdox分析源码作为数据支撑，之后以freemarker作为模板进行渲染，在成功的做出了一套生成Interface的代码后放弃了这个方案，因为时间不够多了，这种方式不够灵活，虽然能够完成功能，但bug越写越多，当断则断，我就直接换了下一个方案。

使用javaparser对源码进行修改，这个方案写一半也及时放弃了，因为javaparser说实话代码生成方面自然是没得说,但在源码分析方面不如qdox,他没有得到一个类型的全限定名，没有办法得到全限定名，我就没有办法对其做修改。因为要根据全限定名确定是否要加interface是否要将此依赖额外暴露等等，除了全限定名，javaparser还有很多存在局限的地方。

因此又换到了第三个方案，使用Qdox作为数据制成，用javaparser修改源码。也就是现在的方案

#### 1. 生成Interface

interface生成主要考虑以下方面

1.   

#### 2. 生成类

### 3.6 设计修改源码代码

### 3.7 maven集成







## 引用

>Java 9模块化开发：核心原则与实践
>
>深入理解java虚拟机 周志明
>
>JavaParser: VisitedAnalyse, transform and generate your Java code base。

```java
//FileSystemServiceDiscovery.java     这是个全空的文件，为什么会存在。
```



```
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-common</artifactId>
    <version>3.0.11-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>org.apache</groupId>
    <artifactId>DubboPro</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```



todo 接口 static，未处理



在哪里做了权限访问控制

```java
 class org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationPostProcessor.ScanExcludeFilter
 class org.apache.dubbo.config.metadata.MetadataServiceDelegation.URLComparator
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedInjectElement
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedFieldElement
 class org.apache.dubbo.config.spring.ReferenceBean.DubboReferenceLazyInitTargetSource
 interface org.apache.dubbo.config.utils.SimpleReferenceCache.KeyGenerator
 class org.apache.dubbo.config.nested.PrometheusConfig.Exporter
 class org.apache.dubbo.config.spring.context.annotation.DubboConfigConfiguration.Single
 class org.apache.dubbo.config.bootstrap.DubboBootstrap.Module
 class org.apache.dubbo.config.spring.context.annotation.DubboConfigConfiguration.Multiple
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedMethodElement
 class  org.dubbo.config.nested.PrometheusConfig.Pushgateway
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedInjectionMetadata
 class org.apache.dubbo.common.status.Status.Level
 class org.apache.dubbo.remoting.api.ProtocolDetector.Result
 class org.apache.dubbo.metadata.MetadataInfo.ServiceInfo
 class org.apache.dubbo.rpc.model.ProviderModel.RegisterStatedURL
 class org.apache.dubbo.rpc.model.MethodDescriptor.RpcType
```



1.   single mutiple 似乎可以直接挪出来，因为那个比较简单什么都没牵扯，但是有几个class很难办。



```java
// 似乎可以直接将DubboConfigConfiguration挪出来 
class org.apache.dubbo.config.spring.context.annotation.DubboConfigConfiguration.Single
class org.apache.dubbo.config.spring.context.annotation.DubboConfigConfiguration.Multiple
// private不用管
class org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationPostProcessor.ScanExcludeFilter
 class org.apache.dubbo.config.spring.ReferenceBean.DubboReferenceLazyInitTargetSource
    
// package权限外边无引用
 class org.apache.dubbo.config.metadata.MetadataServiceDelegation.URLComparator

// 是个接口可以挪出去
 interface org.apache.dubbo.config.utils.SimpleReferenceCache.KeyGenerator
     
// 类中的枚举
 class org.apache.dubbo.common.status.Status.Level

// 接口中的枚举
 class org.apache.dubbo.remoting.api.ProtocolDetector.Result
 class org.apache.dubbo.rpc.model.MethodDescriptor.RpcType

 // 需要处理
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedFieldElement
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedInjectionMetadata
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedMethodElement
 class org.apache.dubbo.config.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor.AnnotatedInjectElement
     
     
 class org.apache.dubbo.config.nested.PrometheusConfig.Exporter
 class  org.dubbo.config.nested.PrometheusConfig.Pushgateway
     
 class org.apache.dubbo.config.bootstrap.DubboBootstrap.Module

 class org.apache.dubbo.metadata.MetadataInfo.ServiceInfo
 class org.apache.dubbo.rpc.model.ProviderModel.RegisterStatedURL
```



总结一下目前做了哪些工作

1.   对于Annotation和Enum

     直接暴露，挪到外边来

2.   对于interface

     修改方法签名，和类签名后挪出来。同时copyAnnotation

3.   对class

     先生成interface

     在生成class

     再修改源码。

现在还需要做哪些事情

1.   修改源码
2.   内部类
3.   集成入maven
4.   异常处理没关
