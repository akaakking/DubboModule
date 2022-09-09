package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.BaseServiceMetadataIdentifierInterface;
import org.apache.dubbo.metadata.report.identifier.BaseMetadataIdentifier;
import org.apache.dubbo.metadata.report.identifier.KeyTypeEnum;
import java.lang.String;

public interface MetadataIdentifierInterface extends BaseServiceMetadataIdentifierInterface, BaseMetadataIdentifier {

    String getUniqueKey(KeyTypeEnum keyType);

    String getIdentifierKey();

    String getServiceInterface();

    void setServiceInterface(String serviceInterface);

    String getVersion();

    void setVersion(String version);

    String getGroup();

    void setGroup(String group);

    String getSide();

    void setSide(String side);

    String getApplication();

    void setApplication(String application);
}
