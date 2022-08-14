package org.apache.dubbo.Interface;

import ;
import java.util;
import java.lang;
import org.apache.dubbo.rpc.model;

public interface DubboSpringInitContextInterface{
    void markAsBound();
    org.springframework.beans.factory.support.BeanDefinitionRegistry getRegistry();
    org.springframework.beans.factory.config.ConfigurableListableBeanFactory getBeanFactory();
    org.springframework.context.ApplicationContext getApplicationContext();
    ApplicationModel getApplicationModel();
    ModuleModel getModuleModel();
    void setModuleModel(ModuleModel moduleModel);
    boolean isKeepRunningOnSpringClosed();
    void setKeepRunningOnSpringClosed(boolean keepRunningOnSpringClosed);
    Map getModuleAttributes();
    void setModuleAttribute(String key, Object value);

}