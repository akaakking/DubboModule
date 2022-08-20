package org.apache.dubbo.config;

import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.config.annotation.Reference;

public class ReferenceConfig<T> extends ReferenceConfigBase<T> implements ReferenceConfigInterface<T> {

    public StringInterface getServices() {
        return instance.getServices();
    }

    public Set<String> getSubscribedServices() {
        return instance.getSubscribedServices();
    }

    public void setServices(StringInterface services) {
        instance.setServices(services);
    }

    public T get() {
        return instance.get();
    }

    public void destroy() {
        instance.destroy();
    }

    public InvokerInterface<?> getInvoker() {
        return instance.getInvoker();
    }

    public Callable<Void> getDestroyRunner() {
        return instance.getDestroyRunner();
    }

    public ReferenceConfig() {
        instance = (ReferenceConfigInterface) DubboClassLoader.getInstance(ReferenceConfig.class.getName());
    }

    public ReferenceConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ReferenceConfigInterface) DubboClassLoader.getInstance(ReferenceConfig.class.getName(), params, args);
    }

    public ReferenceConfig(Reference reference) {
        Class[] params = new Class[]{Reference.class};
        Object[] args = new Object[]{reference};
        instance = (ReferenceConfigInterface) DubboClassLoader.getInstance(ReferenceConfig.class.getName(), params, args);
    }

    public ReferenceConfig(ModuleModelInterface moduleModel, Reference reference) {
        Class[] params = new Class[]{ModuleModelInterface.class, Reference.class};
        Object[] args = new Object[]{moduleModel, reference};
        instance = (ReferenceConfigInterface) DubboClassLoader.getInstance(ReferenceConfig.class.getName(), params, args);
    }
}
