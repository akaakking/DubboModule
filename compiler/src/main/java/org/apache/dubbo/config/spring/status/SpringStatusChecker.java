package org.apache.dubbo.config.spring.status;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class SpringStatusChecker implements SpringStatusCheckerInterface {

    public StatusInterface check() {
        return instance.check();
    }

    public SpringStatusChecker(ApplicationModelInterface applicationModel) {
        Class[] params = new Class[]{ApplicationModelInterface.class};
        Object[] args = new Object[]{applicationModel};
        instance = (SpringStatusCheckerInterface) DubboClassLoader.getInstance(SpringStatusChecker.class.getName(), params, args);
    }

    public SpringStatusChecker(ApplicationContext applicationContext) {
        Class[] params = new Class[]{ApplicationContext.class};
        Object[] args = new Object[]{applicationContext};
        instance = (SpringStatusCheckerInterface) DubboClassLoader.getInstance(SpringStatusChecker.class.getName(), params, args);
    }
}
