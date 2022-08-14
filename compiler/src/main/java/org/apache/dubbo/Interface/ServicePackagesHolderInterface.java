package org.apache.dubbo.Interface;

import java.lang;

public interface ServicePackagesHolderInterface{
    void addScannedPackage(String apackage);
    boolean isPackageScanned(String packageName);
    void addScannedClass(String className);
    boolean isClassScanned(String className);

}