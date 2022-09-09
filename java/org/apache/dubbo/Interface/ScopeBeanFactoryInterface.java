package org.apache.dubbo.Interface;

import java.lang.Class;
import java.lang.String;
import java.lang.Object;
import java.util.function.Function;
import T;

public interface ScopeBeanFactoryInterface {

    <T> T registerBean(Class<T> bean);

    <T> T registerBean(String name, Class<T> clazz);

    void registerBean(Object bean);

    void registerBean(String name, Object bean);

    <T> T getOrRegisterBean(Class<T> type);

    <T> T getOrRegisterBean(String name, Class<T> type);

    <T> T getOrRegisterBean(Class<T> type, Function<? super Class<T>, ? extends T> mappingFunction);

    <T> T getOrRegisterBean(String name, Class<T> type, Function<? super Class<T>, ? extends T> mappingFunction);

    <T> T initializeBean(T bean);

    <T> T getBean(Class<T> type);

    <T> T getBean(String name, Class<T> type);

    void destroy();
}
