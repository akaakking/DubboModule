package org.apache.dubbo.Interface;

import ;
import java.util;

public interface EnvironmentUtilsInterface{
    Map extractProperties(org.springframework.core.env.ConfigurableEnvironment environment);
    SortedMap filterDubboProperties(org.springframework.core.env.ConfigurableEnvironment environment);

}