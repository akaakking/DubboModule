package org.apache.dubbo.config.spring;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigCenterBean implements ConfigCenterBeanInterface {

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

    public ConfigCenterBean() {
        instance = (ConfigCenterBeanInterface) DubboClassLoader.getInstance(ConfigCenterBean.class.getName());
    }

    public ConfigCenterBean(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigCenterBeanInterface) DubboClassLoader.getInstance(ConfigCenterBean.class.getName(), params, args);
    }
}
