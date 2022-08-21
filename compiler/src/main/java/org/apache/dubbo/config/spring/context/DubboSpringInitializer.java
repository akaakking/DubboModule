package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;

public class DubboSpringInitializer implements DubboSpringInitializerInterface {

    protected DubboSpringInitializerInterface instance;

    public static void initialize(BeanDefinitionRegistry registry) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboSpringInitializer.class.getName());
        Method method = klass.getMethod("initialize", BeanDefinitionRegistry.class);
        method.invoke(registry);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
    }

    public static boolean remove(BeanDefinitionRegistry registry) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboSpringInitializer.class.getName());
        Method method = klass.getMethod("remove", BeanDefinitionRegistry.class);
        return (boolean)method.invoke(registry);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static boolean remove(ApplicationContext springContext) {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboSpringInitializer.class.getName());
        Method method = klass.getMethod("remove", ApplicationContext.class);
        return (boolean)method.invoke(springContext);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public DubboSpringInitializerInterface getInternalInstance() {
        return instance;
    }

    protected DubboSpringInitializer() {
        instance = (DubboSpringInitializerInterface) DubboClassLoader.getInstance(DubboSpringInitializer.class.getName());
    }
}
