package org.apache.dubbo.Interface;

import java.lang.String;
import org.apache.dubbo.Interface.ServiceModelInterface;
import org.apache.dubbo.rpc.model.ServiceModel;

public interface BaseServiceMetadataInterface {

    String getDisplayServiceKey();

    String getServiceKey();

    void generateServiceKey();

    void setServiceKey(String serviceKey);

    String getServiceInterfaceName();

    void setServiceInterfaceName(String serviceInterfaceName);

    String getVersion();

    void setVersion(String version);

    String getGroup();

    void setGroup(String group);

    ServiceModelInterface getServiceModel();

    void setServiceModel(ServiceModelInterface serviceModel);
}
