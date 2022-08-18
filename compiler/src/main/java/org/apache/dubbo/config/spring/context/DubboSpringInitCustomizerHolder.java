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

    public Set<DubboSpringInitCustomizer> getCustomizers() {
        return instance.getCustomizers();
    }

    public static DubboSpringInitCustomizerHolderInterface get() {
        Method method = instance.getClass().getMethod();
        return method.invoke();
    }
}
