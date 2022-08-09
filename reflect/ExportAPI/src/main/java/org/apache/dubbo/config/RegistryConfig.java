package org.apache.dubbo.config;

import org.apache.dubbo.Interface.RegistryConfigInterface;
import org.apache.dubbo.InternalClassLoad;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:33
 */
public class RegistryConfig implements RegistryConfigInterface {
    private RegistryConfigInterface instance;

    public RegistryConfig(String arg) {
        try {
            instance = InternalClassLoad.getInstance(RegistryConfigInterface.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    RegistryConfigInterface getInstance() {
        return instance;
    }
}
