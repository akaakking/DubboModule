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
    void setApplication(ApplicationConfigInterface application);
    void setRegistry(RegistryConfigInterface registry);
    void setMetadataReportConfig(MetadataReportConfigInterface metadataReportConfig);
    void export();
}
// 等会不行把参数名字该全

/*
|---root(class)
            methods
                method1
                    parameters
                        parameter1
                            Type
                            name
                        parameter2
                method2
                method3
            importPackages
                package1
                package2
                package3
            className
            typeParameters
            只用内部没有继承只有实现接口，继承是只继承了spring的一些东西。
 */
