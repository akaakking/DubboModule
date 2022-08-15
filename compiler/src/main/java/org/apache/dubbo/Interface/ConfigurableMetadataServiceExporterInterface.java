package org.apache.dubbo.Interface;

import java.util.List;

public interface ConfigurableMetadataServiceExporterInterface extends Object{
    ConfigurableMetadataServiceExporterInterface export();
    ConfigurableMetadataServiceExporterInterface unexport();
    boolean isExported();
    void setMetadataService(MetadataServiceDelegationInterface metadataService);
    List getExportedURLs();
}