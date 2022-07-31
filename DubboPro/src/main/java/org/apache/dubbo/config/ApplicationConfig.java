package org.apache.dubbo.config;

import org.apache.dubbo.InternalClassLoad;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/31 下午2:57
 */
public class ApplicationConfig {
    private Object instance;

    public ApplicationConfig(String arg) {
        try {
            this.instance = InternalClassLoad.getInstance(ApplicationConfig.class,arg);
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
