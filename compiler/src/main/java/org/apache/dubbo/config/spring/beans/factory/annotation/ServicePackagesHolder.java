package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServicePackagesHolder implements ServicePackagesHolderInterface {

    public void addScannedPackage(StringInterface apackage) {
        instance.addScannedPackage(apackage);
    }

    public boolean isPackageScanned(StringInterface packageName) {
        return instance.isPackageScanned(packageName);
    }

    public void addScannedClass(StringInterface className) {
        instance.addScannedClass(className);
    }

    public boolean isClassScanned(StringInterface className) {
        return instance.isClassScanned(className);
    }

    protected ServicePackagesHolderInterface instance;
}
