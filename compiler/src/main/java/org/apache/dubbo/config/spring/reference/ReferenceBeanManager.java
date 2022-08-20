package org.apache.dubbo.config.spring.reference;

import org.springframework.context.ApplicationContextAware;
import java.util.List;
import java.util.Collection;
import org.springframework.context.ApplicationContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBeanManager implements ReferenceBeanManagerInterface {

    public void addReference(ReferenceBeanInterface referenceBean) {
        instance.addReference(referenceBean.getInternalInstance(), referenceBean);
    }

    public void registerReferenceKeyAndBeanName(String referenceKey, String referenceBeanNameOrAlias) {
        instance.registerReferenceKeyAndBeanName(referenceKey, referenceBeanNameOrAlias);
    }

    public ReferenceBeanInterface getById(String referenceBeanNameOrAlias) {
        return instance.getById(referenceBeanNameOrAlias);
    }

    public List<String> getBeanNamesByKey(String key) {
        return instance.getBeanNamesByKey(key);
    }

    public Collection<ReferenceBeanInterface> getReferences() {
        return instance.getReferences();
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void prepareReferenceBeans() {
        instance.prepareReferenceBeans();
    }

    protected ReferenceBeanManagerInterface instance;

    public ReferenceBeanManagerInterface getInternalInstance() {
        return instance;
    }

    public ReferenceBeanManagerInterface getInternalInstance() {
        return instance;
    }
}
