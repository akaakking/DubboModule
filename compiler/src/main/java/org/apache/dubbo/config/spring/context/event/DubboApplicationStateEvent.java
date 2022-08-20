package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationEvent;
import org.apache.dubbo.common.deploy.DeployState;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboApplicationStateEvent extends ApplicationEvent implements DubboApplicationStateEventInterface {

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public DeployStateInterface getState() {
        return instance.getState();
    }

    public Throwable getCause() {
        return instance.getCause();
    }

    public DubboApplicationStateEventInterface getInternalInstance() {
        return instance;
    }

    public DubboApplicationStateEvent(ApplicationModelInterface applicationModel, DeployStateInterface state) {
        Class[] params = new Class[]{ApplicationModelInterface.class, DeployStateInterface.class};
        Object[] args = new Object[]{applicationModel, state};
        instance = (DubboApplicationStateEventInterface) DubboClassLoader.getInstance(DubboApplicationStateEvent.class.getName(), params, args);
    }

    public DubboApplicationStateEvent(ApplicationModelInterface applicationModel, DeployStateInterface state, Throwable cause) {
        Class[] params = new Class[]{ApplicationModelInterface.class, DeployStateInterface.class, Throwable.class};
        Object[] args = new Object[]{applicationModel, state, cause};
        instance = (DubboApplicationStateEventInterface) DubboClassLoader.getInstance(DubboApplicationStateEvent.class.getName(), params, args);
    }
}
