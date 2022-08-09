package org.apache.dubbo.config;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.ServiceConfigInterface;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/9 上午11:33
 */
public class ServiceConfig<T> implements ServiceConfigInterface<T> {
    private ServiceConfigInterface instance = (ServiceConfigInterface) DubboClassLoader.getInstance(ServiceConfig.class);

    @Override
    public void setInterface(Class<?> klass) {
        instance.setInterface(klass);
    }

    @Override
    public void setRef(T ref) {
        instance.setRef(ref);
    }

    @Override
    public void setApplication(ApplicationConfig application) {
        instance.setApplication((ApplicationConfig) (application.getInstance()));
    }

    @Override
    public void setRegistry(RegistryConfig registry) {
        instance.setRegistry((RegistryConfig) registry.getInstance());
    }

    @Override
    public void setMetadataReportConfig(MetadataReportConfig metadataReportConfig) {
        instance.setMetadataReportConfig((MetadataReportConfig) metadataReportConfig.getInstance());
    }

    @Override
    public void export() {
        instance.export();
    }
}
