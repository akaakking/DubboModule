package org.apache.dubbo.config;

import java.util.List;
import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import java.lang.Object;
import org.apache.dubbo.config.ArgumentConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractMethodConfig;
import java.lang.reflect.Method;
import org.apache.dubbo.config.annotation.Method;

public class MethodConfig extends AbstractMethodConfig implements MethodConfigInterface {

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public AsyncMethodInfoInterface convertMethodConfig2AsyncInfo() {
        return instance.convertMethodConfig2AsyncInfo();
    }

    public String getName() {
        return instance.getName();
    }

    public void setName(String name) {
        instance.setName(name);
    }

    public Integer getStat() {
        return instance.getStat();
    }

    public void setStat(Integer stat) {
        instance.setStat(stat);
    }

    public Boolean isRetry() {
        return instance.isRetry();
    }

    public void setRetry(Boolean retry) {
        instance.setRetry(retry);
    }

    public Boolean isReliable() {
        return instance.isReliable();
    }

    public void setReliable(Boolean reliable) {
        instance.setReliable(reliable);
    }

    public Integer getExecutes() {
        return instance.getExecutes();
    }

    public void setExecutes(Integer executes) {
        instance.setExecutes(executes);
    }

    public Boolean getDeprecated() {
        return instance.getDeprecated();
    }

    public void setDeprecated(Boolean deprecated) {
        instance.setDeprecated(deprecated);
    }

    public List<ArgumentConfigInterface> getArguments() {
        return instance.getArguments();
    }

    public void setArguments(List<? extends ArgumentConfigInterface> arguments) {
        instance.setArguments(arguments);
    }

    public Boolean getSticky() {
        return instance.getSticky();
    }

    public void setSticky(Boolean sticky) {
        instance.setSticky(sticky);
    }

    public Object getOnreturn() {
        return instance.getOnreturn();
    }

    public void setOnreturn(Object onreturn) {
        instance.setOnreturn(onreturn);
    }

    public String getOnreturnMethod() {
        return instance.getOnreturnMethod();
    }

    public void setOnreturnMethod(String onreturnMethod) {
        instance.setOnreturnMethod(onreturnMethod);
    }

    public Object getOnthrow() {
        return instance.getOnthrow();
    }

    public void setOnthrow(Object onthrow) {
        instance.setOnthrow(onthrow);
    }

    public String getOnthrowMethod() {
        return instance.getOnthrowMethod();
    }

    public void setOnthrowMethod(String onthrowMethod) {
        instance.setOnthrowMethod(onthrowMethod);
    }

    public Object getOninvoke() {
        return instance.getOninvoke();
    }

    public void setOninvoke(Object oninvoke) {
        instance.setOninvoke(oninvoke);
    }

    public String getOninvokeMethod() {
        return instance.getOninvokeMethod();
    }

    public void setOninvokeMethod(String oninvokeMethod) {
        instance.setOninvokeMethod(oninvokeMethod);
    }

    public Boolean isReturn() {
        return instance.isReturn();
    }

    public void setReturn(Boolean isReturn) {
        instance.setReturn(isReturn);
    }

    public String getService() {
        return instance.getService();
    }

    public void setService(String service) {
        instance.setService(service);
    }

    public String getServiceId() {
        return instance.getServiceId();
    }

    public void setServiceId(String serviceId) {
        instance.setServiceId(serviceId);
    }

    public void setParentPrefix(String parentPrefix) {
        instance.setParentPrefix(parentPrefix);
    }

    public String getParentPrefix() {
        return instance.getParentPrefix();
    }

    public void addArgument(ArgumentConfigInterface argumentConfig) {
        instance.addArgument(((ArgumentConfig) argumentConfig).getInternalInstance());
    }

    protected MethodConfigInterface instance;

    public static List<MethodConfigInterface> constructMethodConfig(Method[] methods) {
        try { 
          Class klass = DubboClassLoader.getKlass(MethodConfig.class.getName());
        Method method = klass.getMethod("constructMethodConfig", Method[].class);
        return (List<MethodConfigInterface>)method.invoke(methods);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public MethodConfigInterface getInternalInstance() {
        return instance;
    }

    public MethodConfig() {
        instance = (MethodConfigInterface) DubboClassLoader.getInstance(MethodConfig.class.getName());
        super.instance = this.instance;
    }

    public MethodConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (MethodConfigInterface) DubboClassLoader.getInstance(MethodConfig.class.getName(), params, args);
        super.instance = this.instance;
    }

    public MethodConfig(Method method) {
        Class[] params = new Class[]{Method.class};
        Object[] args = new Object[]{method};
        instance = (MethodConfigInterface) DubboClassLoader.getInstance(MethodConfig.class.getName(), params, args);
        super.instance = this.instance;
    }
}
