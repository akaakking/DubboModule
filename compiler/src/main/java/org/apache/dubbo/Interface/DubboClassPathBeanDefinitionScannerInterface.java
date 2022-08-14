package org.apache.dubbo.Interface;

import java.util;
import java.lang;

public interface DubboClassPathBeanDefinitionScannerInterface{
    Set findCandidateComponents(String basePackage);

}