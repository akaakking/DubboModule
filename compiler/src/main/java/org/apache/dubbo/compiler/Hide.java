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
1. 想着将要暴露的东西挪出去的
 */
