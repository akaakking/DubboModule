package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.BaseApplicationMetadataIdentifierInterface;
import org.apache.dubbo.metadata.report.identifier.BaseMetadataIdentifier;
import org.apache.dubbo.metadata.report.identifier.KeyTypeEnum;
import java.lang.String;

public interface SubscriberMetadataIdentifierInterface extends BaseApplicationMetadataIdentifierInterface, BaseMetadataIdentifier {

    String getUniqueKey(KeyTypeEnum keyType);

    String getIdentifierKey();

    String getApplication();

    void setApplication(String application);

    String getRevision();

    void setRevision(String revision);
}
