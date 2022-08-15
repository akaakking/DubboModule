package org.apache.dubbo.Interface;

import java.util.Set;

public interface DubboSpringInitCustomizerHolderInterface {
    DubboSpringInitCustomizerHolderInterface get();
    void addCustomizer(DubboSpringInitCustomizerInterface customizer);
    void clearCustomizers();
    Set getCustomizers();
}