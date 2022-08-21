package org.apache.dubbo.config.spring.status;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.springframework.context.ApplicationContext;

public class DataSourceStatusChecker implements DataSourceStatusCheckerInterface {

    public StatusInterface check() {
        return instance.check();
    }

    protected DataSourceStatusCheckerInterface instance;

    public DataSourceStatusCheckerInterface getInternalInstance() {
        return instance;
    }

    public DataSourceStatusChecker(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (DataSourceStatusCheckerInterface) DubboClassLoader.getInstance(DataSourceStatusChecker.class.getName(), params, args);
    }

    public DataSourceStatusChecker(ApplicationContext context) {
        Class[] params = new Class[]{ApplicationContext.class};
        Object[] args = new Object[]{context};
        instance = (DataSourceStatusCheckerInterface) DubboClassLoader.getInstance(DataSourceStatusChecker.class.getName(), params, args);
    }

    protected DataSourceStatusChecker() {
        instance = (DataSourceStatusCheckerInterface) DubboClassLoader.getInstance(DataSourceStatusChecker.class.getName());
    }
}
