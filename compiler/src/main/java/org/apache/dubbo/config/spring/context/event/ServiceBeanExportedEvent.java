package org.apache.dubbo.config.spring.context.event;

import org.springframework.context.ApplicationEvent;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceBeanExportedEvent extends ApplicationEvent implements ServiceBeanExportedEventInterface {

    public ServiceBeanInterface getServiceBean() {
        return instance.getServiceBean();
    }

    public ServiceBeanExportedEvent(ServiceBeanInterface serviceBean) {
        Class[] params = new Class[]{ServiceBeanInterface.class};
        Object[] args = new Object[]{serviceBean};
        instance = (ServiceBeanExportedEventInterface) DubboClassLoader.getInstance(ServiceBeanExportedEvent.class.getName(), params, args);
    }
}