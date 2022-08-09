package org.apache.dubbo.config;

import org.apache.dubbo.Interface.ApplicationConfigInterface;
import org.apache.dubbo.InternalClassLoad;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:32
 */
public class ApplicationConfig implements ApplicationConfigInterface {
    private ApplicationConfigInterface instance;

    public ApplicationConfig(String arg) {
        try {
            instance = InternalClassLoad.getInstance(ApplicationConfigInterface.class,arg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    ApplicationConfigInterface getInstance() {
        return instance;
    }
}
