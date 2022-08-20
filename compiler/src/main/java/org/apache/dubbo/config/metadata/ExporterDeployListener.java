package org.apache.dubbo.config.metadata;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ExporterDeployListener implements ExporterDeployListenerInterface {

    public void onStarting(ApplicationModelInterface scopeModel) {
        instance.onStarting(scopeModel.getInternalInstance(), scopeModel);
    }

    public void onStarted(ApplicationModelInterface applicationModel) {
        instance.onStarted(applicationModel.getInternalInstance(), applicationModel);
    }

    public void onStopping(ApplicationModelInterface scopeModel) {
        instance.onStopping(scopeModel.getInternalInstance(), scopeModel);
    }

    public ConfigurableMetadataServiceExporterInterface getMetadataServiceExporter() {
        return instance.getMetadataServiceExporter();
    }

    public void setMetadataServiceExporter(ConfigurableMetadataServiceExporterInterface metadataServiceExporter) {
        instance.setMetadataServiceExporter(metadataServiceExporter.getInternalInstance(), metadataServiceExporter);
    }

    public void onModuleStarted(ApplicationModelInterface applicationModel) {
        instance.onModuleStarted(applicationModel.getInternalInstance(), applicationModel);
    }

    public void onStopped(ApplicationModelInterface scopeModel) {
        instance.onStopped(scopeModel.getInternalInstance(), scopeModel);
    }

    public void onFailure(ApplicationModelInterface scopeModel, Throwable cause) {
        instance.onFailure(scopeModel.getInternalInstance(), scopeModel, cause);
    }

    public int getPriority() {
        return instance.getPriority();
    }

    protected ExporterDeployListenerInterface instance;

    public ExporterDeployListenerInterface getInternalInstance() {
        return instance;
    }

    public ExporterDeployListenerInterface getInternalInstance() {
        return instance;
    }
}
