package org.apache.dubbo.Interface;

import org.apache.dubbo.common.deploy.DeployListener;
import org.apache.dubbo.rpc.model.ApplicationModel;

public interface ApplicationDeployListenerInterface extends DeployListener<ApplicationModelInterface> {

    void onModuleStarted(ApplicationModelInterface applicationModel);
}
