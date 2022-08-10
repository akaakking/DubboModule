package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/10 下午6:57
 */
public class RegistryConfig {
    private Object instance;

    public RegistryConfig(String arg) {
        this.instance = DubboClassLoader.getInstance(RegistryConfig.class, arg);
    }

    public Object getInstance() {
        return this.instance;
    }
}
