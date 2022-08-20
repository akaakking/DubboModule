package org.apache.dubbo.config.bootstrap.builders;

import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import org.apache.dubbo.config.bootstrap.builders.AbstractMethodBuilder;

public class MethodBuilder extends AbstractMethodBuilder<MethodConfig, MethodBuilder> implements MethodBuilderInterface {

    public MethodBuilderInterface name(StringInterface name) {
        return instance.name(name);
    }

    public MethodBuilderInterface stat(IntegerInterface stat) {
        return instance.stat(stat);
    }

    public MethodBuilderInterface retry(BooleanInterface retry) {
        return instance.retry(retry);
    }

    public MethodBuilderInterface reliable(BooleanInterface reliable) {
        return instance.reliable(reliable);
    }

    public MethodBuilderInterface executes(IntegerInterface executes) {
        return instance.executes(executes);
    }

    public MethodBuilderInterface deprecated(BooleanInterface deprecated) {
        return instance.deprecated(deprecated);
    }

    public MethodBuilderInterface sticky(BooleanInterface sticky) {
        return instance.sticky(sticky);
    }

    public MethodBuilderInterface isReturn(BooleanInterface isReturn) {
        return instance.isReturn(isReturn);
    }

    public MethodBuilderInterface oninvoke(ObjectInterface oninvoke) {
        return instance.oninvoke(oninvoke);
    }

    public MethodBuilderInterface oninvokeMethod(StringInterface oninvokeMethod) {
        return instance.oninvokeMethod(oninvokeMethod);
    }

    public MethodBuilderInterface onreturn(ObjectInterface onreturn) {
        return instance.onreturn(onreturn);
    }

    public MethodBuilderInterface onreturnMethod(StringInterface onreturnMethod) {
        return instance.onreturnMethod(onreturnMethod);
    }

    public MethodBuilderInterface onthrow(ObjectInterface onthrow) {
        return instance.onthrow(onthrow);
    }

    public MethodBuilderInterface onthrowMethod(StringInterface onthrowMethod) {
        return instance.onthrowMethod(onthrowMethod);
    }

    public MethodBuilderInterface addArguments(List<? extends ArgumentConfigInterface> arguments) {
        return instance.addArguments(arguments);
    }

    public MethodBuilderInterface addArgument(ArgumentConfigInterface argument) {
        return instance.addArgument(argument);
    }

    public MethodBuilderInterface service(StringInterface service) {
        return instance.service(service);
    }

    public MethodBuilderInterface serviceId(StringInterface serviceId) {
        return instance.serviceId(serviceId);
    }

    public MethodConfigInterface build() {
        return instance.build();
    }
}
