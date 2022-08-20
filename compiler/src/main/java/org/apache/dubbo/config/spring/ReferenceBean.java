package org.apache.dubbo.config.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import java.util.Map;
import org.springframework.beans.MutablePropertyValues;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBean<T> implements ReferenceBeanInterface<T> {

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void setBeanClassLoader(ClassLoaderInterface classLoader) {
        instance.setBeanClassLoader(classLoader);
    }

    public void setBeanName(StringInterface name) {
        instance.setBeanName(name);
    }

    public T getObject() {
        return instance.getObject();
    }

    public Class<?> getObjectType() {
        return instance.getObjectType();
    }

    public boolean isSingleton() {
        return instance.isSingleton();
    }

    public void afterPropertiesSet() {
        instance.afterPropertiesSet();
    }

    public void destroy() {
        instance.destroy();
    }

    public StringInterface getId() {
        return instance.getId();
    }

    public void setId(StringInterface id) {
        instance.setId(id);
    }

    public Class<?> getInterfaceClass() {
        return instance.getInterfaceClass();
    }

    public StringInterface getServiceInterface() {
        return instance.getServiceInterface();
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public StringInterface getKey() {
        return instance.getKey();
    }

    public Map<String, Object> getReferenceProps() {
        return instance.getReferenceProps();
    }

    public MutablePropertyValuesInterface getPropertyValues() {
        return instance.getPropertyValues();
    }

    public ReferenceConfigInterface getReferenceConfig() {
        return instance.getReferenceConfig();
    }

    public void setKeyAndReferenceConfig(StringInterface key, ReferenceConfigInterface referenceConfig) {
        instance.setKeyAndReferenceConfig(key, referenceConfig);
    }

    protected ReferenceBeanInterface instance;

    public ReferenceBean() {
        instance = (ReferenceBeanInterface) DubboClassLoader.getInstance(ReferenceBean.class.getName());
    }

    public ReferenceBean(Map<String, Object> referenceProps) {
        Class[] params = new Class[]{MapMap<String,Object>.class};
        Object[] args = new Object[]{referenceProps};
        instance = (ReferenceBeanInterface) DubboClassLoader.getInstance(ReferenceBean.class.getName(), params, args);
    }
}
