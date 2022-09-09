package org.apache.dubbo.Interface;

import org.apache.dubbo.common.lang.Prioritized;

public interface LoadingStrategyInterface extends Prioritized {

    String directory();

    boolean preferExtensionClassLoader();

    String[] excludedPackages();

    String[] includedPackages();

    String[] includedPackagesInCompatibleType();

    String[] onlyExtensionClassLoaderPackages();

    boolean overridden();

    String getName();
}
