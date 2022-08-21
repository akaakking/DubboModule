package org.apache.dubbo.common;

import java.lang.String;
import org.apache.dubbo.rpc.model.ServiceModel;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;

public class BaseServiceMetadata implements BaseServiceMetadataInterface {

    public String getDisplayServiceKey() {
        return instance.getDisplayServiceKey();
    }

    public String getServiceKey() {
        return instance.getServiceKey();
    }

    public void generateServiceKey() {
        instance.generateServiceKey();
    }

    public void setServiceKey(String serviceKey) {
        instance.setServiceKey(serviceKey);
    }

    public String getServiceInterfaceName() {
        return instance.getServiceInterfaceName();
    }

    public void setServiceInterfaceName(String serviceInterfaceName) {
        instance.setServiceInterfaceName(serviceInterfaceName);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public void setVersion(String version) {
        instance.setVersion(version);
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public void setGroup(String group) {
        instance.setGroup(group);
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public void setServiceModel(ServiceModelInterface serviceModel) {
        instance.setServiceModel(((ServiceModel) serviceModel).getInternalInstance());
    }

    protected BaseServiceMetadataInterface instance;

    public static String buildServiceKey(String path, String group, String version) {
        try { 
          Class klass = DubboClassLoader.getKlass(BaseServiceMetadata.class.getName());
        Method method = klass.getMethod("buildServiceKey", String.class, String.class, String.class);
        return (String)method.invoke(path, group, version);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String versionFromServiceKey(String serviceKey) {
        try { 
          Class klass = DubboClassLoader.getKlass(BaseServiceMetadata.class.getName());
        Method method = klass.getMethod("versionFromServiceKey", String.class);
        return (String)method.invoke(serviceKey);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String groupFromServiceKey(String serviceKey) {
        try { 
          Class klass = DubboClassLoader.getKlass(BaseServiceMetadata.class.getName());
        Method method = klass.getMethod("groupFromServiceKey", String.class);
        return (String)method.invoke(serviceKey);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String interfaceFromServiceKey(String serviceKey) {
        try { 
          Class klass = DubboClassLoader.getKlass(BaseServiceMetadata.class.getName());
        Method method = klass.getMethod("interfaceFromServiceKey", String.class);
        return (String)method.invoke(serviceKey);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static BaseServiceMetadataInterface revertDisplayServiceKey(String displayKey) {
        try { 
          Class klass = DubboClassLoader.getKlass(BaseServiceMetadata.class.getName());
        Method method = klass.getMethod("revertDisplayServiceKey", String.class);
        return (BaseServiceMetadataInterface)method.invoke(displayKey);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String keyWithoutGroup(String interfaceName, String version) {
        try { 
          Class klass = DubboClassLoader.getKlass(BaseServiceMetadata.class.getName());
        Method method = klass.getMethod("keyWithoutGroup", String.class, String.class);
        return (String)method.invoke(interfaceName, version);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public BaseServiceMetadataInterface getInternalInstance() {
        return instance;
    }

    protected BaseServiceMetadata() {
        instance = (BaseServiceMetadataInterface) DubboClassLoader.getInstance(BaseServiceMetadata.class.getName());
    }
}
