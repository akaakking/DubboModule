package org.apache.dubbo.Interface;

import org.springframework.core.env.ConfigurableEnvironment;
import java.util.Map;
import java.util.SortedMap;

public interface EnvironmentUtilsInterface {
    Map extractProperties(ConfigurableEnvironment environment);
    SortedMap filterDubboProperties(ConfigurableEnvironment environment);
}