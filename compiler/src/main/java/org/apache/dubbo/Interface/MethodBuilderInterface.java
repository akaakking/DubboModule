package org.apache.dubbo.Interface;

import java.lang;
import java.util;

public interface MethodBuilderInterface{
    MethodBuilderInterface name(String name);
    MethodBuilderInterface stat(Integer stat);
    MethodBuilderInterface retry(Boolean retry);
    MethodBuilderInterface reliable(Boolean reliable);
    MethodBuilderInterface executes(Integer executes);
    MethodBuilderInterface deprecated(Boolean deprecated);
    MethodBuilderInterface sticky(Boolean sticky);
    MethodBuilderInterface isReturn(Boolean isReturn);
    MethodBuilderInterface oninvoke(Object oninvoke);
    MethodBuilderInterface oninvokeMethod(String oninvokeMethod);
    MethodBuilderInterface onreturn(Object onreturn);
    MethodBuilderInterface onreturnMethod(String onreturnMethod);
    MethodBuilderInterface onthrow(Object onthrow);
    MethodBuilderInterface onthrowMethod(String onthrowMethod);
    MethodBuilderInterface addArguments(List arguments);
    MethodBuilderInterface addArgument(ArgumentConfigInterface argument);
    MethodBuilderInterface service(String service);
    MethodBuilderInterface serviceId(String serviceId);
    MethodConfigInterface build();

}