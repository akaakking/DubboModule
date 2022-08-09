package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.RegistryConfigInterface;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:33
 */
public class RegistryConfig implements RegistryConfigInterface {
    private RegistryConfigInterface instance;

    public RegistryConfig(String arg) {
        instance = (RegistryConfigInterface) DubboClassLoader.getInstance(RegistryConfig.class,arg);
    }

    RegistryConfigInterface getInstance() {
        return instance;
    }
}
