package org.apache.dubbo.config;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboShutdownHook implements DubboShutdownHookInterface {

    public void run() {
        instance.run();
    }

    public void register() {
        instance.register();
    }

    public void unregister() {
        instance.unregister();
    }

    public boolean getRegistered() {
        return instance.getRegistered();
    }

    protected DubboShutdownHookInterface instance;

    public DubboShutdownHook(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (DubboShutdownHookInterface) DubboClassLoader.getInstance(DubboShutdownHook.class.getName(), params, args);
    }
}
