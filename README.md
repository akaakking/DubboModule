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



首先我们得明确以下问题

直接挪出去带来的问题

1.   得在选择加载方向的时候，排除掉他，直接用app加载。（可以考虑在加载器处维护一个HashSet）
2.   里边引用到了某些内部接口，所以不太好办。



1.   注解如何暴露

     直接挪出去，没什么不妥，可能需要注意的是，可能引用了并没有暴露的注解

2.   接口如何暴露 

     能直接挪出去吗

     分情况 （如果嫌麻烦就都按类暴露处理）

     1.   没有使用内部接口

          那就直接挪动，想办法对直接暴露的方法，做个统计，将来好向HashSet中添加。

     2.   使用了内部接口

          这个需要和类暴露做相同处理。

3.   类如何暴露

     从interface角度看类的元素

     1.   方法

     2.   方法所带参数。

     从表皮类的角度看类的元素。

     	1. 构造方法
     	1. 普通方法
     	1. 方法所带参数

     这其中最需要注意的地方在于。对于任何参数都得来个getIntstance.



我们需要判断参数是否是接口，是否属于dubbo？



![image-20220815144501024](/home/wfh/.config/Typora/typora-user-images/image-20220815144501024.png)

 

还有以下问题没有解决

1.   函数参数泛型，和返回值泛型，这个主要想一想List<String>
2.   classNameType也有不准确的情况
3.   注解相关没碰(方法和类上的，包内的都没碰)



现在考虑生成代码

到底是用javaparser重构还是，继续用qdox打补丁呢？

重构吧，反正将来改代码的时候还要用到他的api





现在有个问题就是，如果是样例这种形式，那么我在调用serviceConfig的方法的时候是怎么调用的；

我们知道我们所有方法的调用其实都是调用的instance,那我们直接在初始化的时候赋值instance完事。即下边这样

好像直接赋值也可以？反正我们的目的都是为了初始化instance/

```java
public class ServiceConfig<T> implments ServiceConfigInterface<T> extends ServiceCongfigBase<T> {
    public ServiceConfig() {
        instan = “分得分”；
    }
}

public class ServiceConfigBase<T> implments ServiceConfigBaseInterface<T>{
    protect ServiceConfigBaseInterface instance;
    
    // 由于是新类所以用他做参数不会和以往构造方法冲突。
    protect ServiceConfigBase(ServiceConfigBaseInterface fds) {
    }
}
```



很难受的一点是将来用户继承我们的类也没用。。。。。得不到想要的属性以及方法。但接口的话应该是没有问题的，也没有办法用抽象类。

当一个类可被实例化的时候，那么他就要含有一个instance不管他的父类有无。



```java
public DubboShutdownHook(ApplicationModel applicationModel) {
	instance = DubboClassLoader.getInstance();
}

DubboClassLoader.getInstance(); //  获得无参构造生成的对象
// 看一下获得一个方法需要什么吧 需要typr数组和value数组。现在就是说value数组，type数组可能会有点问题。
// 除非将内部construct改掉。否则没办法匹配。
// 原来的全部用interface替代。 接口参数全用interface代替这是必然的。
能不能找到呢？
DubboClassLoader.getInstance(); // 


            for (JavaParameter parameter : method.getParameters()) {
                addParams(parserMethodDeclaration,parameter);
            }
        }
    }

    private void addParams(MethodDeclaration parserMethodDeclaration,JavaParameter javaParameter) {
        Parameter  parameter = new Parameter();
        parameter.setName(javaParameter.getName());

        if (checkName(javaParameter.getType().getBinaryName())) {
            parameter.setType(addInterface(shortName(javaParameter.getType().getGenericValue())));
        } else {
            parameter.setType(javaParameter.getType().getGenericValue());
        }

        parserMethodDeclaration.addParameter(parameter);
    }


           BlockStmt blockStmt = new BlockStmt();
            ExpressionStmt expressionStmt = new ExpressionStmt();
            constructor.setBody(blockStmt);
            blockStmt.addStatement(expressionStmt);

            NameExpr instance = new NameExpr("instance");
            NameExpr DubboClassLoader = new NameExpr("(ServiceConfig)DubboClassLoader");

            MethodCallExpr methodCallExpr = new MethodCallExpr(DubboClassLoader,"getInstance");
            methodCallExpr.addArgument("params");
            methodCallExpr.addArgument("args");

            VariableDeclarationExpr variableDeclarationExpr = new VariableDeclarationExpr();
            VariableDeclarator variableDeclarator = new VariableDeclarator();
            variableDeclarator.setName("params");
            variableDeclarator.setType(new ClassOrInterfaceType("class[]"));
            variableDeclarator.setInitializer(methodCallExpr);
            NodeList<VariableDeclarator> variableDeclarators = new NodeList<>();
            variableDeclarators.add(variableDeclarator);
            variableDeclarationExpr.setVariables(variableDeclarators);
            expressionStmt.setExpression(variableDeclarationExpr);




            blockStmt.addStatement(methodCallExpr);


```







解决问题还是挺方便的

1.   注解没有添加 todo   已做
2.   abstract innerclass  enum这些没想好怎么处理
     1.   abstact的继承问题，继承外部的abstract类是否有意义。

3.   对内部api里外部api的引用做统计
4.   修改源码
5.   带有spi注解的接口
6.   空构造
7.   强转

