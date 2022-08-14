package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface ConfigCenterBeanInterface{
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void destroy();
    void setEnvironment(org.springframework.core.env.Environment environment);
    org.springframework.context.ApplicationContext getApplicationContext();
    Boolean getIncludeSpringEnv();
    void setIncludeSpringEnv(Boolean includeSpringEnv);

}