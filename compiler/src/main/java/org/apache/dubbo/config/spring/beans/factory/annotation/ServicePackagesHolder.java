package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServicePackagesHolder implements ServicePackagesHolderInterface {

    public void addScannedPackage(String apackage) {
        instance.addScannedPackage(apackage);
    }

    public boolean isPackageScanned(String packageName) {
        return instance.isPackageScanned(packageName);
    }

    public void addScannedClass(String className) {
        instance.addScannedClass(className);
    }

    public boolean isClassScanned(String className) {
        return instance.isClassScanned(className);
    }

    protected ServicePackagesHolderInterface instance;

    public ServicePackagesHolderInterface getInternalInstance() {
        return instance;
    }
}
