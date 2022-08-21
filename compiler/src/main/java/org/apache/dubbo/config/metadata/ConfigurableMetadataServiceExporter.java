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
        instance.setMetadataService(((MetadataServiceDelegation) metadataService).getInternalInstance());
    }

    public List<URLInterface> getExportedURLs() {
        return instance.getExportedURLs();
    }

    protected ConfigurableMetadataServiceExporterInterface instance;

    public ConfigurableMetadataServiceExporterInterface getInternalInstance() {
        return instance;
    }

    public ConfigurableMetadataServiceExporter(ApplicationModelInterface applicationModel, MetadataServiceDelegationInterface metadataService) {
        Class[] params = new Class[]{ApplicationModelInterface.class, MetadataServiceDelegationInterface.class};
        Object[] args = new Object[]{applicationModel, metadataService};
        instance = (ConfigurableMetadataServiceExporterInterface) DubboClassLoader.getInstance(ConfigurableMetadataServiceExporter.class.getName(), params, args);
    }

    protected ConfigurableMetadataServiceExporter() {
        instance = (ConfigurableMetadataServiceExporterInterface) DubboClassLoader.getInstance(ConfigurableMetadataServiceExporter.class.getName());
    }
}
