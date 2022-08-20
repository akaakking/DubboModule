package org.apache.dubbo.config.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationEventPublisherAware;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.ServiceConfig;

public class ServiceBean<T> extends ServiceConfig<T> implements ServiceBeanInterface<T> {

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void setBeanName(StringInterface name) {
        instance.setBeanName(name);
    }

    public ServiceInterface getService() {
        return instance.getService();
    }

    public void afterPropertiesSet() {
        instance.afterPropertiesSet();
    }

    public StringInterface getBeanName() {
        return instance.getBeanName();
    }

    public void destroy() {
        instance.destroy();
    }

    public void setApplicationEventPublisher(ApplicationEventPublisherInterface applicationEventPublisher) {
        instance.setApplicationEventPublisher(applicationEventPublisher);
    }

    public ServiceBean() {
        instance = (ServiceBeanInterface) DubboClassLoader.getInstance(ServiceBean.class.getName());
    }

    public ServiceBean(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (ServiceBeanInterface) DubboClassLoader.getInstance(ServiceBean.class.getName(), params, args);
    }

    public ServiceBean(Service service) {
        Class[] params = new Class[]{Service.class};
        Object[] args = new Object[]{service};
        instance = (ServiceBeanInterface) DubboClassLoader.getInstance(ServiceBean.class.getName(), params, args);
    }

    public ServiceBean(ModuleModelInterface moduleModel, Service service) {
        Class[] params = new Class[]{ModuleModelInterface.class, Service.class};
        Object[] args = new Object[]{moduleModel, service};
        instance = (ServiceBeanInterface) DubboClassLoader.getInstance(ServiceBean.class.getName(), params, args);
    }
}
