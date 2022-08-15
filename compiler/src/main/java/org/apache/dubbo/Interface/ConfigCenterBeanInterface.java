package org.apache.dubbo.Interface;

import org.springframework.core.env.Environment;
import org.springframework.context.ApplicationContext;

public interface ConfigCenterBeanInterface {
    void setApplicationContext(ApplicationContext applicationContext);
    void destroy();
    void setEnvironment(Environment environment);
    ApplicationContext getApplicationContext();
    Boolean getIncludeSpringEnv();
    void setIncludeSpringEnv(Boolean includeSpringEnv);
}