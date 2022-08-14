package org.apache.dubbo.Interface;

import ;
import java.util;
import java.lang;

public interface ReferenceCreatorInterface{
    ReferenceConfigInterface build();
    ReferenceCreatorInterface create(Map attributes, org.springframework.context.ApplicationContext applicationContext);
    ReferenceCreatorInterface defaultInterfaceClass(Class interfaceClass);

}