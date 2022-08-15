package org.apache.dubbo.Interface;

import java.util.Map;
import org.springframework.context.ApplicationContext;

public interface ReferenceCreatorInterface {
    ReferenceConfigInterface<T> build();
    ReferenceCreatorInterface create(Map attributes, ApplicationContext applicationContext);
    ReferenceCreatorInterface defaultInterfaceClass(Class interfaceClass);
}