package org.apache.dubbo.config.spring.reference;

import java.lang.Class;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;
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
        try { 
          Class klass = DubboClassLoader.getKlass(ReferenceCreator.class.getName());
        Method method = klass.getMethod("create", Map.class, ApplicationContext.class);
        return (ReferenceCreatorInterface)method.invoke(attributes, applicationContext);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public ReferenceCreatorInterface getInternalInstance() {
        return instance;
    }

    protected ReferenceCreator() {
        instance = (ReferenceCreatorInterface) DubboClassLoader.getInstance(ReferenceCreator.class.getName());
    }
}
