package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/10 下午6:56
 */
public class MetadataReportConfig {
    private Object instance;

    public MetadataReportConfig(String arg) {
        this.instance = DubboClassLoader.getInstance(MetadataReportConfig.class, arg);
    }

    public Object getInstance() {
        return this.instance;
    }
}
