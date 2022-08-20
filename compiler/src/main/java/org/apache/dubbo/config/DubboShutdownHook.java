package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.Thread;

public class DubboShutdownHook extends Thread implements DubboShutdownHookInterface {

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

    public DubboShutdownHookInterface getInternalInstance() {
        return instance;
    }

    public DubboShutdownHookInterface getInternalInstance() {
        return instance;
    }

    public DubboShutdownHook(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (DubboShutdownHookInterface) DubboClassLoader.getInstance(DubboShutdownHook.class.getName(), params, args);
    }
}
