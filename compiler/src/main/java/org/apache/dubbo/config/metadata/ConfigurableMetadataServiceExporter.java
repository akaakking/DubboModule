package org.apache.dubbo.config.metadata;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ConfigurableMetadataServiceExporter implements ConfigurableMetadataServiceExporterInterface {

    public ConfigurableMetadataServiceExporterInterface export() {
        return instance.export();
    }

    public ConfigurableMetadataServiceExporterInterface unexport() {
        return instance.unexport();
    }

    public boolean isExported() {
        return instance.isExported();
    }

    public void setMetadataService(MetadataServiceDelegationInterface metadataService) {
        instance.setMetadataService(metadataService);
    }

    public List<URL> getExportedURLs() {
        return instance.getExportedURLs();
    }

    public ConfigurableMetadataServiceExporter(ApplicationModelInterface applicationModel, MetadataServiceDelegationInterface metadataService) {
        Class[] params = new Class[]{ApplicationModelInterface.class, MetadataServiceDelegationInterface.class};
        Object[] args = new Object[]{applicationModel, metadataService};
        instance = (ConfigurableMetadataServiceExporterInterface) DubboClassLoader.getInstance(ConfigurableMetadataServiceExporter.class.getName(), params, args);
    }
}
