package org.apache.dubbo.common.extension;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class LoadingStrategy implements LoadingStrategyInterface {

    public String directory() {
        return instance.directory();
    }

    public boolean preferExtensionClassLoader() {
        return instance.preferExtensionClassLoader();
    }

    public String[] excludedPackages() {
        return instance.excludedPackages();
    }

    public String[] includedPackages() {
        return instance.includedPackages();
    }

    public String[] includedPackagesInCompatibleType() {
        return instance.includedPackagesInCompatibleType();
    }

    public String[] onlyExtensionClassLoaderPackages() {
        return instance.onlyExtensionClassLoaderPackages();
    }

    public boolean overridden() {
        return instance.overridden();
    }

    public String getName() {
        return instance.getName();
    }
}
