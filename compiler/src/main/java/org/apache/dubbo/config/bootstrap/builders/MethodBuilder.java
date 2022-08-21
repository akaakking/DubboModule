package org.apache.dubbo.config.bootstrap.builders;

import java.lang.String;
import java.lang.Integer;
import java.lang.Boolean;
import java.lang.Object;
import java.util.List;
import org.apache.dubbo.config.ArgumentConfig;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractMethodBuilder;

public class MethodBuilder extends AbstractMethodBuilder<MethodConfig, MethodBuilder> implements MethodBuilderInterface {

    public MethodBuilderInterface name(String name) {
        return instance.name(name);
    }

    public MethodBuilderInterface stat(Integer stat) {
        return instance.stat(stat);
    }

    public MethodBuilderInterface retry(Boolean retry) {
        return instance.retry(retry);
    }

    public MethodBuilderInterface reliable(Boolean reliable) {
        return instance.reliable(reliable);
    }

    public MethodBuilderInterface executes(Integer executes) {
        return instance.executes(executes);
    }

    public MethodBuilderInterface deprecated(Boolean deprecated) {
        return instance.deprecated(deprecated);
    }

    public MethodBuilderInterface sticky(Boolean sticky) {
        return instance.sticky(sticky);
    }

    public MethodBuilderInterface isReturn(Boolean isReturn) {
        return instance.isReturn(isReturn);
    }

    public MethodBuilderInterface oninvoke(Object oninvoke) {
        return instance.oninvoke(oninvoke);
    }

    public MethodBuilderInterface oninvokeMethod(String oninvokeMethod) {
        return instance.oninvokeMethod(oninvokeMethod);
    }

    public MethodBuilderInterface onreturn(Object onreturn) {
        return instance.onreturn(onreturn);
    }

    public MethodBuilderInterface onreturnMethod(String onreturnMethod) {
        return instance.onreturnMethod(onreturnMethod);
    }

    public MethodBuilderInterface onthrow(Object onthrow) {
        return instance.onthrow(onthrow);
    }

    public MethodBuilderInterface onthrowMethod(String onthrowMethod) {
        return instance.onthrowMethod(onthrowMethod);
    }

    public MethodBuilderInterface addArguments(List<? extends ArgumentConfigInterface> arguments) {
        return instance.addArguments(arguments);
    }

    public MethodBuilderInterface addArgument(ArgumentConfigInterface argument) {
        return instance.addArgument(((ArgumentConfig) argument).getInternalInstance());
    }

    public MethodBuilderInterface service(String service) {
        return instance.service(service);
    }

    public MethodBuilderInterface serviceId(String serviceId) {
        return instance.serviceId(serviceId);
    }

    public MethodConfigInterface build() {
        return instance.build();
    }

    protected MethodBuilderInterface instance;

    public MethodBuilderInterface getInternalInstance() {
        return instance;
    }

    protected MethodBuilder() {
        instance = (MethodBuilderInterface) DubboClassLoader.getInstance(MethodBuilder.class.getName());
        super.instance = this.instance;
    }
}
