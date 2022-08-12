# 1. 开发规划



## 1.1 前期工作

从贴合用户的角度，用反射做了个demo,证明了我们目前的思路确实可行，唯一会有冲突的是javassit的问题不过目前也已经解决掉了。

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

# 2. 目前在做的事情

根据现有经验我们需要按照这样的步骤做

1.   根据包生成相关Interface

     可以做一个比较好的抽象

     1.   可以由配置文件得到要暴露的包的信息（做成module-info那样）
     2.   可以根据注解@hide实现，方法级别的隐藏，比如说标注了@hide的方法，我们在将来生成的Interface中不包含他。

     思路是：

     1.   根据配置文件先初始化一个List<class>决定好要暴露哪些包下的类
     2.   根据具体类找出要暴露的接口,生成Interface

2.   改动原有代码，让原有类实现Interface

     这个比较难做的点在于，implment interface之后，要对代码中 interface包含的方法修改参数

3.   编译打包项目
