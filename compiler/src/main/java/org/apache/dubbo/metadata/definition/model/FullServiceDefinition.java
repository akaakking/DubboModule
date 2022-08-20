package org.apache.dubbo.metadata.definition.model;

import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.metadata.definition.model.ServiceDefinition;

public class FullServiceDefinition extends ServiceDefinition implements FullServiceDefinitionInterface {

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public void setParameters(Map<String, String> parameters) {
        instance.setParameters(parameters);
    }

    public String toString() {
        return instance.toString();
    }

    public FullServiceDefinitionInterface getInternalInstance() {
        return instance;
    }

    public FullServiceDefinitionInterface getInternalInstance() {
        return instance;
    }
}
