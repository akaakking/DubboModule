package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceBeanExportedEvent implements ServiceBeanExportedEventInterface {

    public ServiceBeanInterface getServiceBean() {
        return instance.getServiceBean();
    }

    protected ServiceBeanExportedEventInterface instance;

    public ServiceBeanExportedEvent(ServiceBeanInterface serviceBean) {
        Class[] params = new Class[]{ServiceBeanInterface.class};
        Object[] args = new Object[]{serviceBean};
        instance = (ServiceBeanExportedEventInterface) DubboClassLoader.getInstance(ServiceBeanExportedEvent.class.getName(), params, args);
    }
}
