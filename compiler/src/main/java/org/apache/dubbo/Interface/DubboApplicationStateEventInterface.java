package org.apache.dubbo.Interface;

import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.common.deploy.DeployState;

public interface DubboApplicationStateEventInterface {
    ApplicationModel getApplicationModel();
    DeployState getState();
    Throwable getCause();
}