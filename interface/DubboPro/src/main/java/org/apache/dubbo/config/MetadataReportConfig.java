package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:32
 */
public class MetadataReportConfig implements MetadataReportConfigInterface {
    private MetadataReportConfigInterface instance;

    public MetadataReportConfig(String arg) {
        instance = (MetadataReportConfigInterface) DubboClassLoader.getInstance(MetadataReportConfig.class,arg);
    }

    MetadataReportConfigInterface getInstance() {
        return instance;
    }
}
