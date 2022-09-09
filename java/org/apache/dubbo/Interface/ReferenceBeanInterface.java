package org.apache.dubbo.Interface;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import java.lang.ClassLoader;
import java.lang.String;
import java.util.Map;
import org.springframework.beans.MutablePropertyValues;
import org.apache.dubbo.Interface.ReferenceConfigInterface;
import org.apache.dubbo.config.ReferenceConfig;

public interface ReferenceBeanInterface<T> extends FactoryBean<T>, ApplicationContextAware, BeanClassLoaderAware, BeanNameAware, InitializingBean, DisposableBean {

    void setApplicationContext(ApplicationContext applicationContext);

    void setBeanClassLoader(ClassLoader classLoader);

    void setBeanName(String name);

    T getObject();

    Class<?> getObjectType();

    boolean isSingleton();

    void afterPropertiesSet();

    void destroy();

    String getId();

    void setId(String id);

    Class<?> getInterfaceClass();

    String getServiceInterface();

    String getGroup();

    String getVersion();

    String getKey();

    Map<String, Object> getReferenceProps();

    MutablePropertyValues getPropertyValues();

    ReferenceConfigInterface getReferenceConfig();

    void setKeyAndReferenceConfig(String key, ReferenceConfigInterface referenceConfig);
}
