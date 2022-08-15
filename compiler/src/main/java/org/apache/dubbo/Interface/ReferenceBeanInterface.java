package org.apache.dubbo.Interface;

import java.util.Map;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.ApplicationContext;

public interface ReferenceBeanInterface<T> extends Object, org.springframework.beans.factory.FactoryBean, org.springframework.context.ApplicationContextAware, org.springframework.beans.factory.BeanClassLoaderAware, org.springframework.beans.factory.BeanNameAware, org.springframework.beans.factory.InitializingBean, org.springframework.beans.factory.DisposableBean{
    void setApplicationContext(ApplicationContext applicationContext);
    void setBeanClassLoader(ClassLoader classLoader);
    void setBeanName(String name);
    T getObject();
    Class getObjectType();
    boolean isSingleton();
    void afterPropertiesSet();
    void destroy();
    String getId();
    void setId(String id);
    Class getInterfaceClass();
    String getServiceInterface();
    String getGroup();
    String getVersion();
    String getKey();
    Map getReferenceProps();
    MutablePropertyValues getPropertyValues();
    ReferenceConfigInterface<T> getReferenceConfig();
    void setKeyAndReferenceConfig(String key, ReferenceConfigInterface<T> referenceConfig);
}