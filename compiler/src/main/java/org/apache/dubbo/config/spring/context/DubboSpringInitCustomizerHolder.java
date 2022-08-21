package org.apache.dubbo.config.spring.context;

import org.apache.dubbo.config.spring.context.DubboSpringInitCustomizer;
import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;

public class DubboSpringInitCustomizerHolder implements DubboSpringInitCustomizerHolderInterface {

    public void addCustomizer(DubboSpringInitCustomizerInterface customizer) {
        instance.addCustomizer(((DubboSpringInitCustomizer) customizer).getInternalInstance());
    }

    public void clearCustomizers() {
        instance.clearCustomizers();
    }

    public Set<DubboSpringInitCustomizerInterface> getCustomizers() {
        return instance.getCustomizers();
    }

    protected DubboSpringInitCustomizerHolderInterface instance;

    public static DubboSpringInitCustomizerHolderInterface get() {
        try { 
          Class klass = DubboClassLoader.getKlass(DubboSpringInitCustomizerHolder.class.getName());
        Method method = klass.getMethod("get");
        return (DubboSpringInitCustomizerHolderInterface)method.invoke();
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public DubboSpringInitCustomizerHolderInterface getInternalInstance() {
        return instance;
    }

    protected DubboSpringInitCustomizerHolder() {
        instance = (DubboSpringInitCustomizerHolderInterface) DubboClassLoader.getInstance(DubboSpringInitCustomizerHolder.class.getName());
    }
}
