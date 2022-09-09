package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.BaseServiceMetadataIdentifierInterface;
import org.apache.dubbo.metadata.report.identifier.BaseMetadataIdentifier;
import org.apache.dubbo.metadata.report.identifier.KeyTypeEnum;
import java.lang.String;

public interface ServiceMetadataIdentifierInterface extends BaseServiceMetadataIdentifierInterface, BaseMetadataIdentifier {

    String getUniqueKey(KeyTypeEnum keyType);

    String getIdentifierKey();

    void setRevision(String revision);

    void setProtocol(String protocol);

    String toString();
}
