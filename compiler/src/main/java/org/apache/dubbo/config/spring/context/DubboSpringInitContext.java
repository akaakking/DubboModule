package org.apache.dubbo.config.spring.context;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboSpringInitContext implements DubboSpringInitContextInterface {

    public void markAsBound() {
        instance.markAsBound();
    }

    public BeanDefinitionRegistry getRegistry() {
        return instance.getRegistry();
    }

    public ConfigurableListableBeanFactory getBeanFactory() {
        return instance.getBeanFactory();
    }

    public ApplicationContext getApplicationContext() {
        return instance.getApplicationContext();
    }

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ModuleModelInterface getModuleModel() {
        return instance.getModuleModel();
    }

    public void setModuleModel(ModuleModelInterface moduleModel) {
        instance.setModuleModel(((ModuleModel) moduleModel).getInternalInstance());
    }

    public boolean isKeepRunningOnSpringClosed() {
        return instance.isKeepRunningOnSpringClosed();
    }

    public void setKeepRunningOnSpringClosed(boolean keepRunningOnSpringClosed) {
        instance.setKeepRunningOnSpringClosed(keepRunningOnSpringClosed);
    }

    public Map<String, Object> getModuleAttributes() {
        return instance.getModuleAttributes();
    }

    public void setModuleAttribute(String key, Object value) {
        instance.setModuleAttribute(key, value);
    }

    protected DubboSpringInitContextInterface instance;

    public DubboSpringInitContextInterface getInternalInstance() {
        return instance;
    }

    protected DubboSpringInitContext() {
        instance = (DubboSpringInitContextInterface) DubboClassLoader.getInstance(DubboSpringInitContext.class.getName());
    }
}
