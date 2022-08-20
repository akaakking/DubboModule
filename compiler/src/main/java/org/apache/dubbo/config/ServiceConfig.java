package org.apache.dubbo.config;

import java.util.concurrent.Callable;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.ServiceConfigBase;
import org.apache.dubbo.config.annotation.Service;

public class ServiceConfig<T> extends ServiceConfigBase<T> implements ServiceConfigInterface<T> {

    public boolean isExported() {
        return instance.isExported();
    }

    public boolean isUnexported() {
        return instance.isUnexported();
    }

    public void unexport() {
        instance.unexport();
    }

    public void init() {
        instance.init();
    }

    public void export() {
        instance.export();
    }

    public void addServiceListener(ServiceListenerInterface listener) {
        instance.addServiceListener(listener);
    }

    public Callable<Void> getDestroyRunner() {
        return instance.getDestroyRunner();
    }

    public ServiceConfig() {
        instance = (ServiceConfigInterface) DubboClassLoader.getInstance(ServiceConfig.class.getName());
    }

    public ServiceConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ServiceConfigInterface) DubboClassLoader.getInstance(ServiceConfig.class.getName(), params, args);
    }

    public ServiceConfig(Service service) {
        Class[] params = new Class[]{Service.class};
        Object[] args = new Object[]{service};
        instance = (ServiceConfigInterface) DubboClassLoader.getInstance(ServiceConfig.class.getName(), params, args);
    }

    public ServiceConfig(ModuleModelInterface moduleModel, Service service) {
        Class[] params = new Class[]{ModuleModelInterface.class, Service.class};
        Object[] args = new Object[]{moduleModel, service};
        instance = (ServiceConfigInterface) DubboClassLoader.getInstance(ServiceConfig.class.getName(), params, args);
    }
}
