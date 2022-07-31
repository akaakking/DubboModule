package org.apache.dubbo.config;

import org.apache.dubbo.InternalClassLoad;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/31 下午3:25
 */
public class RegistryConfig {
    private Object instance;

    public RegistryConfig(String arg) {
        try {
            this.instance = InternalClassLoad.getInstance(RegistryConfig.class,arg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getInstance() {
        return instance;
    }
}
