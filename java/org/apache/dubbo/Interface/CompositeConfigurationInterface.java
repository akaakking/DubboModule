package org.apache.dubbo.Interface;

import org.apache.dubbo.common.config.Configuration;
import java.lang.String;

public interface CompositeConfigurationInterface extends Configuration {

    boolean isDynamicIncluded();

    void setDynamicIncluded(boolean dynamicIncluded);

    void addConfiguration(Configuration configuration);

    void addConfigurationFirst(Configuration configuration);

    void addConfiguration(int pos, Configuration configuration);

    Object getInternalProperty(String key);
}
