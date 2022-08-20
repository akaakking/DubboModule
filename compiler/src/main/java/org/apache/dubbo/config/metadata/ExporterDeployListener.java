package org.apache.dubbo.config.metadata;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExporterDeployListener implements ExporterDeployListenerInterface {

    public void onStarting(ApplicationModelInterface scopeModel) {
        instance.onStarting(scopeModel.getInternalInstance());
    }

    public void onStarted(ApplicationModelInterface applicationModel) {
        instance.onStarted(applicationModel.getInternalInstance());
    }

    public void onStopping(ApplicationModelInterface scopeModel) {
        instance.onStopping(scopeModel.getInternalInstance());
    }

    public ConfigurableMetadataServiceExporterInterface getMetadataServiceExporter() {
        return instance.getMetadataServiceExporter();
    }

    public void setMetadataServiceExporter(ConfigurableMetadataServiceExporterInterface metadataServiceExporter) {
        instance.setMetadataServiceExporter(metadataServiceExporter.getInternalInstance());
    }

    public void onModuleStarted(ApplicationModelInterface applicationModel) {
        instance.onModuleStarted(applicationModel.getInternalInstance());
    }

    public void onStopped(ApplicationModelInterface scopeModel) {
        instance.onStopped(scopeModel.getInternalInstance());
    }

    public void onFailure(ApplicationModelInterface scopeModel, Throwable cause) {
        instance.onFailure(scopeModel.getInternalInstance(), cause);
    }

    public int getPriority() {
        return instance.getPriority();
    }

    protected ExporterDeployListenerInterface instance;

    public ExporterDeployListenerInterface getInternalInstance() {
        return instance;
    }
}
