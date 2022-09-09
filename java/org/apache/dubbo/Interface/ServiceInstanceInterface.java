package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.util.Map;
import java.util.SortedMap;
import java.lang.String;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.metadata.MetadataInfo;

public interface ServiceInstanceInterface extends Serializable {

    String getServiceName();

    String getHost();

    int getPort();

    String getAddress();

    boolean isEnabled();

    boolean isHealthy();

    Map<String, String> getMetadata();

    SortedMap<String, String> getSortedMetadata();

    String getRegistryCluster();

    void setRegistryCluster(String registryCluster);

    Map<String, String> getExtendParams();

    String getExtendParam(String key);

    String putExtendParam(String key, String value);

    String putExtendParamIfAbsent(String key, String value);

    String removeExtendParam(String key);

    Map<String, String> getAllParams();

    void setApplicationModel(ApplicationModelInterface applicationModel);

    ApplicationModelInterface getApplicationModel();

    ApplicationModelInterface getOrDefaultApplicationModel();

    String getMetadata(String name);

    String getMetadata(String name, String defaultValue);

    MetadataInfoInterface getServiceMetadata();

    void setServiceMetadata(MetadataInfoInterface serviceMetadata);

    InstanceAddressURLInterface toURL(String protocol);
}
