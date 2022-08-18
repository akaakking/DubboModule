package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.apache.dubbo.config.spring.beans.factory.annotation.ServiceBeanNameBuilder;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.annotation.Reference;
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
}
