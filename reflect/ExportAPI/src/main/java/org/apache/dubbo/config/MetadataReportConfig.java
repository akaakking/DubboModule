package org.apache.dubbo.config;

import org.apache.dubbo.Interface.MetadataReportConfigInterface;
import org.apache.dubbo.InternalClassLoad;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:32
 */
public class MetadataReportConfig implements MetadataReportConfigInterface {
    private MetadataReportConfigInterface instance;

    public MetadataReportConfig(String arg) {
        try {
            instance = InternalClassLoad.getInstance(MetadataReportConfigInterface.class,arg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    MetadataReportConfigInterface getInstance() {
        return instance;
    }
}
