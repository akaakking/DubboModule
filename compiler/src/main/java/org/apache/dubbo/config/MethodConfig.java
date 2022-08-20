package org.apache.dubbo.config;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.AbstractMethodConfig;
import org.apache.dubbo.config.annotation.Method;

public class MethodConfig extends AbstractMethodConfig implements MethodConfigInterface {

    public List<String> getPrefixes() {
        return instance.getPrefixes();
    }

    public AsyncMethodInfoInterface convertMethodConfig2AsyncInfo() {
        return instance.convertMethodConfig2AsyncInfo();
    }

    public StringInterface getName() {
        return instance.getName();
    }

    public void setName(StringInterface name) {
        instance.setName(name);
    }

    public IntegerInterface getStat() {
        return instance.getStat();
    }

    public void setStat(IntegerInterface stat) {
        instance.setStat(stat);
    }

    public BooleanInterface isRetry() {
        return instance.isRetry();
    }

    public void setRetry(BooleanInterface retry) {
        instance.setRetry(retry);
    }

    public BooleanInterface isReliable() {
        return instance.isReliable();
    }

    public void setReliable(BooleanInterface reliable) {
        instance.setReliable(reliable);
    }

    public IntegerInterface getExecutes() {
        return instance.getExecutes();
    }

    public void setExecutes(IntegerInterface executes) {
        instance.setExecutes(executes);
    }

    public BooleanInterface getDeprecated() {
        return instance.getDeprecated();
    }

    public void setDeprecated(BooleanInterface deprecated) {
        instance.setDeprecated(deprecated);
    }

    public List<ArgumentConfigInterface> getArguments() {
        return instance.getArguments();
    }

    public void setArguments(List<? extends ArgumentConfigInterface> arguments) {
        instance.setArguments(arguments);
    }

    public BooleanInterface getSticky() {
        return instance.getSticky();
    }

    public void setSticky(BooleanInterface sticky) {
        instance.setSticky(sticky);
    }

    public ObjectInterface getOnreturn() {
        return instance.getOnreturn();
    }

    public void setOnreturn(ObjectInterface onreturn) {
        instance.setOnreturn(onreturn);
    }

    public StringInterface getOnreturnMethod() {
        return instance.getOnreturnMethod();
    }

    public void setOnreturnMethod(StringInterface onreturnMethod) {
        instance.setOnreturnMethod(onreturnMethod);
    }

    public ObjectInterface getOnthrow() {
        return instance.getOnthrow();
    }

    public void setOnthrow(ObjectInterface onthrow) {
        instance.setOnthrow(onthrow);
    }

    public StringInterface getOnthrowMethod() {
        return instance.getOnthrowMethod();
    }

    public void setOnthrowMethod(StringInterface onthrowMethod) {
        instance.setOnthrowMethod(onthrowMethod);
    }

    public ObjectInterface getOninvoke() {
        return instance.getOninvoke();
    }

    public void setOninvoke(ObjectInterface oninvoke) {
        instance.setOninvoke(oninvoke);
    }

    public StringInterface getOninvokeMethod() {
        return instance.getOninvokeMethod();
    }

    public void setOninvokeMethod(StringInterface oninvokeMethod) {
        instance.setOninvokeMethod(oninvokeMethod);
    }

    public BooleanInterface isReturn() {
        return instance.isReturn();
    }

    public void setReturn(BooleanInterface isReturn) {
        instance.setReturn(isReturn);
    }

    public StringInterface getService() {
        return instance.getService();
    }

    public void setService(StringInterface service) {
        instance.setService(service);
    }

    public StringInterface getServiceId() {
        return instance.getServiceId();
    }

    public void setServiceId(StringInterface serviceId) {
        instance.setServiceId(serviceId);
    }

    public void setParentPrefix(StringInterface parentPrefix) {
        instance.setParentPrefix(parentPrefix);
    }

    public StringInterface getParentPrefix() {
        return instance.getParentPrefix();
    }

    public void addArgument(ArgumentConfigInterface argumentConfig) {
        instance.addArgument(argumentConfig);
    }

    public static List<MethodConfigInterface> constructMethodConfig(MethodInterface[] methods) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(constructMethodConfig, Method[].class);
        return method.invoke(methods);
    }

    public MethodConfig() {
        instance = (MethodConfigInterface) DubboClassLoader.getInstance(MethodConfig.class.getName());
    }

    public MethodConfig(ModuleModelInterface moduleModel) {
        Class[] params = new Class[]{ModuleModelInterface.class};
        Object[] args = new Object[]{moduleModel};
        instance = (MethodConfigInterface) DubboClassLoader.getInstance(MethodConfig.class.getName(), params, args);
    }

    public MethodConfig(Method method) {
        Class[] params = new Class[]{Method.class};
        Object[] args = new Object[]{method};
        instance = (MethodConfigInterface) DubboClassLoader.getInstance(MethodConfig.class.getName(), params, args);
    }
}
