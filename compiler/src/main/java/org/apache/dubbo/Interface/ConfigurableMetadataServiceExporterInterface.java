package org.apache.dubbo.Interface;

import java.util;

public interface ConfigurableMetadataServiceExporterInterface{
    ConfigurableMetadataServiceExporterInterface export();
    ConfigurableMetadataServiceExporterInterface unexport();
    boolean isExported();
    void setMetadataService(MetadataServiceDelegationInterface metadataService);
    List getExportedURLs();

}