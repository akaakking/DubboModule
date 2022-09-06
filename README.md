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

 // todo







## 3. jar嵌套迷惑类加载器

### 3.1 理论依据

我们利用AppClassLoader只能加载标准目录格式的jar包的特点来向AppClassLoader隐藏我们的类，就是我们可以将我们的jar包做成这样

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

     也就是说打破了原有的双亲委派

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

ServiceConfig和ApplicationConfig这些依旧是代理空类

```java
public class MetadataReportConfig implements MetadataReportConfigInterface {
    private MetadataReportConfigInterface instance;

    public MetadataReportConfig(String arg) {
        instance = (MetadataReportConfigInterface) DubboClassLoader.getInstance(MetadataReportConfig.class,arg);
    }

    MetadataReportConfigInterface getInstance() {
        republic class ServiceConfig<T> implements ServiceConfigInterface<T> {
    private ServiceConfigInterface instance = (ServiceConfigInterface) DubboClassLoader.getInstance(ServiceConfig.class);


    @Override
    public void setInterface(Class<?> klass) {
        instance.setInterface(klass);
    }

    @Override
    public void setRef(T ref) {
        instance.setRef(ref);
    }

    @Override
    public void setApplication(ApplicationConfigInterface application) {
        instance.setApplication(((ApplicationConfig)application).getInstance());
    }

    @Override
    public void setRegistry(RegistryConfigInterface registry) {
        instance.setRegistry(((RegistryConfig) registry).getInstance());
    }

    @Override
    public void setMetadataReportConfig(MetadataReportConfigInterface metadataReportConfig) {
        instance.setMetadataReportConfig(((MetadataReportConfig) metadataReportConfig).getInstance());
    }

    @Override
    public void export() {
        instance.export();
    }
}turn instance;
    }
}
```





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

因此又换到了第三个方案，使用Qdox作为数据支撑，用javaparser生成源码。也就是现在的方案。

#### 1. 暴露哪些类

导师说前期先搞的粗粒度一些，先暴露config包下的和带有spi注解的接口。

考虑到以后暴露的范围可能会有所调整，于是本着对修改关闭，对扩展开放的原则，我没有绑定目前的具体的要暴露一些类。而是给出了这样的接口

AbstractGenerator是一个抽象类。他有以下两个抽象方法

```java
/**
	这个方法返回要暴露哪些包
*/
protected abstract Set<String> provideExportPackages();
/**
	考虑到有些类无法用包表示，比如说带有spi注解的接口，于是我们又给了这个方法
*/
protected abstract Set<String> provideExportClasses();
```

那将来我们继承了AbstractGenerator之后，实现这个两个方法，就可以拓展出一个暴露的范围。

比如说目前的这个DefaultAbstractGenerator。

```java
    @Override
    protected Set<String> provideExportPackages() {
        return readConfig(this.exportPackageInfoPath);
    }

    @Override
    protected Set<String> provideExportClasses() {
        Set<String> classNames = new HashSet<>();
        for (JavaClass aClass : jpb.getClasses()) {
            if (aClass.isInterface()) {
                if (isSPIExtensionPoint(aClass)) {
                    classNames.add(aClass.getBinaryName());
                }
            }
        }

        return classNames;
    }
```

还有一个注意的点就是，做了一个这个注解，这个注解可以放在方法，也可以放在类上，放在类上的时候，直接不暴露这个类，放在方法上的时候不暴露这个方法，简单点说就是在生成的interface中不包含这个方法。那么代理类也不包含这个方法。

这样的话我们对于暴露的控制的一个粒度就已经达到了方法级别。而java9 module只能达到包级别

```java
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Hide {
}
```

而在AbstactGenerator中实际上是这样工作的。

```java
    public void generate() {
        initEnvirenment();

        // get all need to export class
        Set<String> exportPackages = provideExportPackages();
        addExportPackages(exportPackages);
        Set<String> exportClasses = provideExportClasses();
        addExportClasses(exportClasses);

        classGenerator = new ClassGenerator(this);
        interfaceGenerator = new InterfaceGenerator(this);

        dealExportClasses();

        // 额外暴露和直接暴露都应该被记录，将来做过滤。
        dealExtraExport();

        saveDirectExportInfo();

        System.out.println(this.extraExports.size());
    }
```

还有一个重要的点是，对于extraExport的处理，因为尽管我们在外边做了代理类减少了其他非目标暴露范围的类的暴露，但是在方法签名（包括像方法参数，方法返回值，方法泛型），类的泛型，类实现的接口，类继承的类，还是会牵扯着暴露很多类，那么对于这些类（extraExport），我们也会做相应的处理。

处理方法是相同的也是为其生成相应的接口之后在生成相应的类放在外边做代理。

```java
public interface ApplicationModelInterface extends ScopeModelInterface {

    FrameworkModelInterface getFrameworkModel();

    ModuleModelInterface newModule();

    EnvironmentInterface getModelEnvironment();

    ConfigManagerInterface getApplicationConfigManager();

    ServiceRepositoryInterface getApplicationServiceRepository();

    ExecutorRepository getApplicationExecutorRepository();

    ApplicationConfigInterface getCurrentConfig();

    String getApplicationName();

    String tryGetApplicationName();

    void removeModule(ModuleModelInterface moduleModel);

    List<ModuleModelInterface> getModuleModels();

    List<ModuleModelInterface> getPubModuleModels();

    ModuleModelInterface getDefaultModule();

    ModuleModelInterface getInternalModule();

    void setEnvironment(EnvironmentInterface environment);

    void setConfigManager(ConfigManagerInterface configManager);

    void setServiceRepository(ServiceRepositoryInterface serviceRepository);

    void addClassLoader(ClassLoader classLoader);

    void removeClassLoader(ClassLoader classLoader);

    ApplicationDeployer getDeployer();

    void setDeployer(ApplicationDeployer deployer);
}

```

#### 2. 生成接口

有了暴露范围之后就根据暴露范围生成接口

这里一下几点值得一提

1.   首先我们让生成的接口之间，也遵循内部的父子类关系，这样减少了冗余方法的生成。
2.   在interface中只暴露public 非 static的方法，对于static的方法，我们不能通过接口去掉，而是在生成的类中通过反射去掉。
3.   生成的接口全在org.apache.dubbo.Interface包下，而没有放在对应类的包下
4.   对于内部接口interface我们不再外边为其生成interface和class,而是对其签名做一个修改之后挪到外部，这里主要是考虑一方面，这样spi才能起作用，另一方面，也减少了interface和class的产生。对于枚举和注解是直接暴露的，对于直接暴露的类，最会会输出一个txt文件，供DubboClassLoader将来做过滤。

#### 3. 生成类

这个主要是利用JavaParser去拼凑。

1.   拼凑非static方法

     ```java
         @Override()
         public void setVersion(String version) {
             instance.setVersion(version.getInstance);
         }
     ```

     

2.   拼凑构造方法

     ```java
         protected AbstractServiceConfig() {
             this.instance = (AbstractServiceConfigInterface) DubboClassLoader.getInstance(AbstractServiceConfig.class.getName());
             super.instance = this.instance;
         }
     ```

     

3.   拼凑域

     ```java
     protected AbstractServiceConfigInterface instance;
     ```

4.   凭凑类头部

     ```java
     public class AbstractServiceConfig extends AbstractInterfaceConfig implements AbstractServiceConfigInterface {
        ........
     }
     ```

5.   ### 拼凑static方法

     ```java
         public static List<MethodConfigInterface> constructMethodConfig(MethodInterface[] methods) {
             try { 
               Class klass = DubboClassLoader.getKlass(MethodConfig.class.getName());
             Method method = klass.getMethod("constructMethodConfig", Method[].class);
             return (List<MethodConfigInterface>)method.invoke(null, methods);
                     } catch (NoSuchMethodException e) {
                 e.printStackTrace();
             } catch (InvocationTargetException e) {
                 e.printStackTrace();
             } catch (IllegalAccessException e) {
                 e.printStackTrace();
             };
             return null;
         }
     ```

### 3.6 设计修改源码代码

#### 1. 修改类的声明

这个主要是让他们implments相应的接口，这个目前已经实现了

#### 2. 修改方法签名

这个比较的麻烦，主要是考虑到javaparser没办法得到类型的全限定名，所以我得根据Qdox做好Method签名与javaParser相应方法的匹配，这样才能去修改方法签名。这个目前也做好了。

#### 3. 修改方法块

这个是个大工程，也是对dubbo内部修改最多的地方就是他得对每一处的方法块进行扫描，看是否需要强转

比如说,下边这个表达式

```java
ApplictionConfig app = (AppInterf)getApplicationConfig();
```

原本getApplicationConfig返回的是ApplictionConfig类型，但由于我们更改了方法签名，现在他返回的是ApplucationConfigInterface类型，也就是他得父类类型，那么这个时候就需要去做一个强制类型装换

```java
ApplictionConfig app = （ApplicationConfigInterface）getApplicationConfig();
```

那么目前就是在这一阶段。

### 3.7 maven集成



统计：

在config包下 || 带有spi注解     247个类

采用方案一 extra 200 

采用方案二 extra 560 



​                                                                                                                                                                                                             

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
