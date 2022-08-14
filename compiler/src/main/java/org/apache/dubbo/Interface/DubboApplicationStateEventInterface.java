package org.apache.dubbo.Interface;

import java.lang;
import org.apache.dubbo.rpc.model;
import org.apache.dubbo.common.deploy;

public interface DubboApplicationStateEventInterface{
    ApplicationModel getApplicationModel();
    DeployState getState();
    Throwable getCause();

}