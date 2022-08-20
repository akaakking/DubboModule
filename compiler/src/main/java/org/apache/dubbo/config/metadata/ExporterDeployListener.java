package org.apache.dubbo.config.metadata;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExporterDeployListener implements ExporterDeployListenerInterface {

    public void onStarting(ApplicationModelInterface scopeModel) {
        instance.onStarting(scopeModel);
    }

    public void onStarted(ApplicationModelInterface applicationModel) {
        instance.onStarted(applicationModel);
    }

    public void onStopping(ApplicationModelInterface scopeModel) {
        instance.onStopping(scopeModel);
    }

    public ConfigurableMetadataServiceExporterInterface getMetadataServiceExporter() {
        return instance.getMetadataServiceExporter();
    }

    public void setMetadataServiceExporter(ConfigurableMetadataServiceExporterInterface metadataServiceExporter) {
        instance.setMetadataServiceExporter(metadataServiceExporter);
    }

    public void onModuleStarted(ApplicationModelInterface applicationModel) {
        instance.onModuleStarted(applicationModel);
    }

    public void onStopped(ApplicationModelInterface scopeModel) {
        instance.onStopped(scopeModel);
    }

    public void onFailure(ApplicationModelInterface scopeModel, ThrowableInterface cause) {
        instance.onFailure(scopeModel, cause);
    }

    public int getPriority() {
        return instance.getPriority();
    }

    protected ExporterDeployListenerInterface instance;
}
