package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ApplicationModel;

public interface ExporterDeployListenerInterface extends Object, ApplicationDeployListener, Prioritized{
    void onStarting(ApplicationModel scopeModel);
    void onStarted(ApplicationModel applicationModel);
    void onStopping(ApplicationModel scopeModel);
    ConfigurableMetadataServiceExporterInterface getMetadataServiceExporter();
    void setMetadataServiceExporter(ConfigurableMetadataServiceExporterInterface metadataServiceExporter);
    void onModuleStarted(ApplicationModel applicationModel);
    void onStopped(ApplicationModel scopeModel);
    void onFailure(ApplicationModel scopeModel, Throwable cause);
    int getPriority();
}