package org.apache.dubbo.compiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Hide {
}

/*
总结一下现在是什么情况
1. 想着将要暴露的东西挪出去的,但是没办法让他们对于内部的加载走类加载器了。
2. 也就是说暴露给用户的必须走类加载器？也不一定在我看来ApplicationConfig直接暴露出去也没什么错。因为他对于内部没有依赖吗？

如果要做成模块化那样的话


 */
