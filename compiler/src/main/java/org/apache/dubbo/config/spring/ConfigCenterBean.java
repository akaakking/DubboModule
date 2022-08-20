package org.apache.dubbo.config.spring;

import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.ConfigCenterConfig;

public class ConfigCenterBean extends ConfigCenterConfig implements ConfigCenterBeanInterface {

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void destroy() {
        instance.destroy();
    }

    public void setEnvironment(EnvironmentInterface environment) {
        instance.setEnvironment(environment);
    }

    public ApplicationContextInterface getApplicationContext() {
        return instance.getApplicationContext();
    }

    public BooleanInterface getIncludeSpringEnv() {
        return instance.getIncludeSpringEnv();
    }

    public void setIncludeSpringEnv(BooleanInterface includeSpringEnv) {
        instance.setIncludeSpringEnv(includeSpringEnv);
    }

    public ConfigCenterBean() {
        instance = (ConfigCenterBeanInterface) DubboClassLoader.getInstance(ConfigCenterBean.class.getName());
    }

    public ConfigCenterBean(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (ConfigCenterBeanInterface) DubboClassLoader.getInstance(ConfigCenterBean.class.getName(), params, args);
    }
}
