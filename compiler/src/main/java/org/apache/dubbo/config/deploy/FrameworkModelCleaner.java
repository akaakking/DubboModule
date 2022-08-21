package org.apache.dubbo.config.deploy;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class FrameworkModelCleaner implements FrameworkModelCleanerInterface {

    public boolean isProtocol() {
        return instance.isProtocol();
    }

    public void onDestroy(FrameworkModelInterface frameworkModel) {
        instance.onDestroy(((FrameworkModel) frameworkModel).getInternalInstance());
    }

    protected FrameworkModelCleanerInterface instance;

    public FrameworkModelCleanerInterface getInternalInstance() {
        return instance;
    }

    protected FrameworkModelCleaner() {
        instance = (FrameworkModelCleanerInterface) DubboClassLoader.getInstance(FrameworkModelCleaner.class.getName());
    }
}
