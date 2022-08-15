package org.apache.dubbo.Interface;

import java.util.Set;

public interface DubboClassPathBeanDefinitionScannerInterface extends org.springframework.context.annotation.ClassPathBeanDefinitionScanner{
    Set findCandidateComponents(String basePackage);
}