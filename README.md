# 1. 开发规划



## 1.1 前期工作

我先根据demo-api启动一个服务的例子，用反射搭了个demo,证明了我们目前的思路确实可行，唯一会有冲突的是javassit的问题不过目前也已经解决掉了。(demo被我删了不好意思，不过精华都提取到目前这个方案了)

## 1.2目前总体思路：

 1.    先用接口实现启动一个服务，解决出现的问题（听起来挺简单的，但细节是魔鬼啊，一个小泛型搞的我就很难受）；

 2.    解决代码生成的问题。这个不会太难，在手写了一些样板代码后，我发现这个其实很好搞的。因为大多数都是很相似的。

       

## 1.3具体方案阐述

首先要声明的是为减少前期开发复杂度，我会先另起一个项目叫DubboPro进行开发，之后在考虑代码生成的阶段，再将这个项目作为dubbo的一个模块（dubbo-module）进行合并开发。



### 1. 包设计

|-DubboPro

​		|- internal.jar

​		|-org

​			|-apache

​				 |-dubbo

​						|- config

​								|- ServiceConfig.class

​						|- Interface

​								|-ServiceConfigInterface.class

​								|-RegistryConfigInterface.class

由于用户签名不能改变，所以我们暴露给用户的类所在包的报名不能发生改变，就保持原样，比如说上图中的ServiceConfig.class,原本是在org.apache.dubbo.config包下，他就还得在这个包下。

interface的话随便放，为了方便我们就把他统一放在Interface这个包下就行了。

### 2. 对于源码的改动

让需要暴露的类实现一个需要暴露的方法的接口，也就是我们org.apache.dubbo.Interface包下的那些，不过既然是实现已有的那么，相当于实现了一个空接口一样，不需要改变其他部分。

### 3. 类加载器设计

​	  只需要注意一点，org.apache.dubbo 包名开头的一律走自定义类加载器（除了org.apache.dubbo.common.bytecode这个包)，其他的没啥，接口设置的友好一些方便以后的使用。

# 2. 目前遇到的问题



