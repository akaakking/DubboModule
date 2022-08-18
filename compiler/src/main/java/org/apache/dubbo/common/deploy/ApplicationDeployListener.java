package org.apache.dubbo.common.deploy;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ApplicationDeployListener implements ApplicationDeployListenerInterface {

    public void onModuleStarted(ApplicationModelInterface applicationModel) {
        instance.onModuleStarted(applicationModel);
    }
}
