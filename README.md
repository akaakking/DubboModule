# 1. 开发规划



## 1.1 前期工作

从贴合用户的角度，用反射做了个demo,证明了我们目前的思路确实可行，唯一会有冲突的是javassit的问题不过目前也已经解决掉了。(demo被我删了，很难受，不过精华都提取到目前这个方案了)

##  1.2 目前总体思路：

 1.    先用接口实现启动一个服务，解决出现的问题（细节是魔鬼）；

 2.    解决代码生成的问题。这个不会太难，在手写了一些样板代码后，我发现这个其实很好搞的。因为大多数都是很相似的。

       

## 1.3  具体方案阐述

首先要声明的是为减少前期开发复杂度，我会先另起一个项目叫DubboPro进行开发，之后在考虑代码生成的阶段，再将这个项目作为dubbo的一个模块（dubbo-module）进行合并开发。



### 1. 包设计

|-DubboPro

------|- internal.jar

------|-org

----------|-apache

--------------|-dubbo

------------------|- config

-----------------------|- ServiceConfig.class

------------------|- Interface

-----------------------|-ServiceConfigInterface.class

-----------------------|-RegistryConfigInterface.class

由于用户签名不能改变，所以我们暴露给用户的类所在包的报名不能发生改变，就保持原样，比如说上图中的ServiceConfig.class,原本是在org.apache.dubbo.config包下，他就还得在这个包下。

interface的话随便放，为了方便我们就把他统一放在Interface这个包下就行了。

### 2. 对于源码的改动

让需要暴露的类实现一个需要暴露的方法的接口，也就是我们org.apache.dubbo.Interface包下的那些，不过既然是实现已有的那么，相当于实现了一个空接口一样，不需要改变其他部分。

### 3. 类加载器设计

​	  只需要注意一点，org.apache.dubbo 包名开头的一律走自定义类加载器（除了org.apache.dubbo.common.bytecode,和org.apache.dubbo.Interface这两个个包)，其他的没啥，接口设置的友好一些方便以后的使用。

# 2. 目前遇到的问题

目前好的一点是终于可以debug了

现在遇到的问题是，在我用接口重做，并将jdk降为1.8之后，运行这个demo

![](./pic/image-20220810155611065.png)

会出现

```java
loader constraint violation: loader 'app' wants to load class org.apache.dubbo.config.ApplicationConfig. A different class with the same name was previously loaded by org.apache.dubbo.DubboClassLoader$InternalURLClassLoader @5bcab519. (org.apache.dubbo.config.ApplicationConfig is in unnamed module of loader org.apache.dubbo.DubboClassLoader$InternalURLClassLoader @5bcab519, parent loader 'app')
```

的问题，应该是说在低版本的时候，有个约束就是，父类加载器，不能加载子类加载器加载过的同名类。

好吧......

那我们先用提前用父类加载器（app）加载一下就解决了这个问题（因为子类加载器，可以加载父类加载器加载过的同名类。）

如下

![image-20220810160627277](./pic/image-20220810160627277.png)

之后报错变了，证明我们的猜想是正确的，但是对现有报错进行排查（很痛苦的排查），我发现错误在于

在AbstractConfigManager的static块里边有个这样的操作

```java
        uniqueConfigTypes.add(ApplicationConfig.class);
        uniqueConfigTypes.add(MonitorConfig.class);
        uniqueConfigTypes.add(MetricsConfig.class);
        uniqueConfigTypes.add(SslConfig.class);
```

按理说，ApplicationClass.class的类加载器是加载AbstractConfigManager的加载器，也就是DubboClassLoader但是实际上是appclassLoad加载器，而appclassloa的加载到是我们的伪装类所以这里会出错误





现在有两种解决方案

1.   类加载器那块得降版本
2.   找一下ApplicationConfig.class这个东西应该是有个什么cache之类的，有没有办法取消掉
