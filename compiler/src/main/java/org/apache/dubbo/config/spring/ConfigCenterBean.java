package org.apache.dubbo.config.spring;

import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.ConfigCenterConfig;

public class ConfigCenterBean extends ConfigCenterConfig implements ConfigCenterBeanInterface {

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void destroy() {
        instance.destroy();
    }

    public void setEnvironment(Environment environment) {
        instance.setEnvironment(environment);
    }

    public ApplicationContext getApplicationContext() {
        return instance.getApplicationContext();
    }

    public Boolean getIncludeSpringEnv() {
        return instance.getIncludeSpringEnv();
    }

    public void setIncludeSpringEnv(Boolean includeSpringEnv) {
        instance.setIncludeSpringEnv(includeSpringEnv);
    }

    protected ConfigCenterBeanInterface instance;

    public ConfigCenterBeanInterface getInternalInstance() {
        return instance;
    }

    public ConfigCenterBean() {
        instance = (ConfigCenterBeanInterface) DubboClassLoader.getInstance(ConfigCenterBean.class.getName());
        super.instance = instance;
    }

    public ConfigCenterBean(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigCenterBeanInterface) DubboClassLoader.getInstance(ConfigCenterBean.class.getName(), params, args);
        super.instance = instance;
    }
}
