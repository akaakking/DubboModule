package org.apache.dubbo.config.spring.reference;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceCreator implements ReferenceCreatorInterface {

    public ReferenceConfigInterface build() {
        return instance.build();
    }

    public ReferenceCreatorInterface defaultInterfaceClass(Class<?> interfaceClass) {
        return instance.defaultInterfaceClass(interfaceClass);
    }

    public static ReferenceCreatorInterface create(Map<String, Object> attributes, ApplicationContext applicationContext) {
        Method method = instance.getClass().getMethod(Map.class, ApplicationContext.class);
        return method.invoke(attributes, applicationContext);
    }
}
