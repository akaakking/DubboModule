package org.apache.dubbo.config;

import org.apache.dubbo.InternalClassLoad;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/7/31 下午3:26
 */
public class MetadataReportConfig {
    private Object instance;

    public MetadataReportConfig(String arg) {
        try {
            this.instance = InternalClassLoad.getInstance(MetadataReportConfig.class,arg);
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
