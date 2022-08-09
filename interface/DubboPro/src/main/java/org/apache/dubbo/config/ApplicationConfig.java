package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.ApplicationConfigInterface;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:32
 */
public class ApplicationConfig implements ApplicationConfigInterface {
    private ApplicationConfigInterface instance;

    public ApplicationConfig(String arg) {
            instance = (ApplicationConfigInterface) DubboClassLoader.getInstance(ApplicationConfig.class,arg);
    }

    ApplicationConfigInterface getInstance() {
        return instance;
    }
}
