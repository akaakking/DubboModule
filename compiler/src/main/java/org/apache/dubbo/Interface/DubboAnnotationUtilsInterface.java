package org.apache.dubbo.Interface;

import java.util.Map;

public interface DubboAnnotationUtilsInterface {
    String resolveInterfaceName(ServiceInterface service, Class defaultInterfaceClass);
    String resolveInterfaceName(Map attributes, Class defaultInterfaceClass);
    String resolveInterfaceName(ReferenceInterface reference, Class defaultInterfaceClass);
    Map convertParameters(String parameters);
}