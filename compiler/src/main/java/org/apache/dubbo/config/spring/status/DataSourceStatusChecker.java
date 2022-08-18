package org.apache.dubbo.config.spring.status;

import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DataSourceStatusChecker implements DataSourceStatusCheckerInterface {

    public StatusInterface check() {
        return instance.check();
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
}
