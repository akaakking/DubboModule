package org.apache.dubbo.Interface;

import java.util.List;
import java.util.Collection;
import org.springframework.context.ApplicationContext;

public interface ReferenceBeanManagerInterface extends Object, org.springframework.context.ApplicationContextAware{
    void addReference(ReferenceBeanInterface<T> referenceBean);
    void registerReferenceKeyAndBeanName(String referenceKey, String referenceBeanNameOrAlias);
    ReferenceBeanInterface<T> getById(String referenceBeanNameOrAlias);
    List getBeanNamesByKey(String key);
    Collection getReferences();
    void setApplicationContext(ApplicationContext applicationContext);
    void prepareReferenceBeans();
}