package org.apache.dubbo.config.spring.context;

import java.util.Set;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboSpringInitCustomizerHolder implements DubboSpringInitCustomizerHolderInterface {

    public void addCustomizer(DubboSpringInitCustomizerInterface customizer) {
        instance.addCustomizer(customizer);
    }

    public void clearCustomizers() {
        instance.clearCustomizers();
    }

    public Set<DubboSpringInitCustomizerInterface> getCustomizers() {
        return instance.getCustomizers();
    }

    protected DubboSpringInitCustomizerHolderInterface instance;

    public static DubboSpringInitCustomizerHolderInterface get() {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(get);
        return method.invoke();
    }
}
