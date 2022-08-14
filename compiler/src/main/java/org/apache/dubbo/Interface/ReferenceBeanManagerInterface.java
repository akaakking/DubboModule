package org.apache.dubbo.Interface;

import ;
import java.lang;
import java.util;

public interface ReferenceBeanManagerInterface{
    void addReference(ReferenceBeanInterface referenceBean);
    void registerReferenceKeyAndBeanName(String referenceKey, String referenceBeanNameOrAlias);
    ReferenceBeanInterface getById(String referenceBeanNameOrAlias);
    List getBeanNamesByKey(String key);
    Collection getReferences();
    void setApplicationContext(org.springframework.context.ApplicationContext applicationContext);
    void prepareReferenceBeans();

}