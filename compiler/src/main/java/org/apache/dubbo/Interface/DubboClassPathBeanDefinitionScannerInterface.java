package org.apache.dubbo.Interface;

import java.util.Set;

public interface DubboClassPathBeanDefinitionScannerInterface {
    Set findCandidateComponents(String basePackage);
}