package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.ServiceDefinitionInterface;
import java.util.Map;

public interface FullServiceDefinitionInterface extends ServiceDefinitionInterface {

    Map<String, String> getParameters();

    void setParameters(Map<String, String> parameters);

    String toString();
}
