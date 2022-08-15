package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ApplicationModel;
import java.util.Map;
import org.apache.dubbo.rpc.model.ModuleModel;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public interface DubboSpringInitContextInterface {
    void markAsBound();
    BeanDefinitionRegistry getRegistry();
    ConfigurableListableBeanFactory getBeanFactory();
    ApplicationContext getApplicationContext();
    ApplicationModel getApplicationModel();
    ModuleModel getModuleModel();
    void setModuleModel(ModuleModel moduleModel);
    boolean isKeepRunningOnSpringClosed();
    void setKeepRunningOnSpringClosed(boolean keepRunningOnSpringClosed);
    Map getModuleAttributes();
    void setModuleAttribute(String key, Object value);
}