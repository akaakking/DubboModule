package org.apache.dubbo.Interface;

import ;
import java.lang;
import java.util;

public interface ReferenceBeanInterface<T>{
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void setBeanClassLoader(ClassLoader classLoader);
    void setBeanName(String name);
    TInterface getObject();
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
    org.springframework.beans.MutablePropertyValues getPropertyValues();
    ReferenceConfigInterface getReferenceConfig();
    void setKeyAndReferenceConfig(String key, ReferenceConfigInterface referenceConfig);

}