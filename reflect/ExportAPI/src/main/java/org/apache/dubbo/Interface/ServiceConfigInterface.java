package org.apache.dubbo.Interface;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MetadataReportConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * //TODO add interface commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:29
 */
public interface ServiceConfigInterface<T> {
    void setInterface(Class<?> klass);
    void setRef(T ref);
    void setApplication(ApplicationConfig application);
    void setRegistry(RegistryConfig registry);
    void setMetadataReportConfig(MetadataReportConfig metadataReportConfig);
    void export();
}
// 等会不行把参数名字该全
