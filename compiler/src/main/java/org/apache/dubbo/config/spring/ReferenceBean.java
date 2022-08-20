package org.apache.dubbo.config.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import java.util.Map;
import org.springframework.beans.MutablePropertyValues;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBean<T> implements ReferenceBeanInterface<T> {

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        instance.setBeanClassLoader(classLoader);
    }

    public void setBeanName(String name) {
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

    public String getId() {
        return instance.getId();
    }

    public void setId(String id) {
        instance.setId(id);
    }

    public Class<?> getInterfaceClass() {
        return instance.getInterfaceClass();
    }

    public String getServiceInterface() {
        return instance.getServiceInterface();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public String getKey() {
        return instance.getKey();
    }

    public Map<String, Object> getReferenceProps() {
        return instance.getReferenceProps();
    }

    public MutablePropertyValues getPropertyValues() {
        return instance.getPropertyValues();
    }

    public ReferenceConfigInterface getReferenceConfig() {
        return instance.getReferenceConfig();
    }

    public void setKeyAndReferenceConfig(String key, ReferenceConfigInterface referenceConfig) {
        instance.setKeyAndReferenceConfig(key, referenceConfig.getInternalInstance());
    }

    protected ReferenceBeanInterface instance;

    public ReferenceBeanInterface getInternalInstance() {
        return instance;
    }

    public ReferenceBean() {
        instance = (ReferenceBeanInterface) DubboClassLoader.getInstance(ReferenceBean.class.getName());
    }

    public ReferenceBean(Map<String, Object> referenceProps) {
        Class[] params = new Class[]{MapMap<String,Object>.class};
        Object[] args = new Object[]{referenceProps};
        instance = (ReferenceBeanInterface) DubboClassLoader.getInstance(ReferenceBean.class.getName(), params, args);
    }
}
