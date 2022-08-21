package org.apache.dubbo.config.spring.reference;

import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.util.Map;
import org.springframework.context.ApplicationContext;

public class ReferenceCreator implements ReferenceCreatorInterface {

    public ReferenceConfigInterface build() {
        return instance.build();
    }

    public ReferenceCreatorInterface defaultInterfaceClass(Class<?> interfaceClass) {
        return instance.defaultInterfaceClass(interfaceClass);
    }

    protected ReferenceCreatorInterface instance;

    public static ReferenceCreatorInterface create(Map<String, Object> attributes, ApplicationContext applicationContext) {
        Class klass = DubboClassLoader.getKlass(ReferenceCreator.class.getName());
        Method method = klass.getMethod("create", Map.class, ApplicationContext.class);
        return method.invoke(attributes, applicationContext);
    }

    public ReferenceCreatorInterface getInternalInstance() {
        return instance;
    }

    protected ReferenceCreator() {
        instance = (ReferenceCreatorInterface) DubboClassLoader.getInstance(ReferenceCreator.class.getName());
    }
}
