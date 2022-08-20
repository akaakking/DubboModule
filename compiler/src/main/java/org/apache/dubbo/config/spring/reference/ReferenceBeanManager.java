package org.apache.dubbo.config.spring.reference;

import org.springframework.context.ApplicationContextAware;
import java.util.List;
import java.util.Collection;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ReferenceBeanManager implements ReferenceBeanManagerInterface {

    public void addReference(ReferenceBeanInterface referenceBean) {
        instance.addReference(referenceBean);
    }

    public void registerReferenceKeyAndBeanName(StringInterface referenceKey, StringInterface referenceBeanNameOrAlias) {
        instance.registerReferenceKeyAndBeanName(referenceKey, referenceBeanNameOrAlias);
    }

    public ReferenceBeanInterface getById(StringInterface referenceBeanNameOrAlias) {
        return instance.getById(referenceBeanNameOrAlias);
    }

    public List<String> getBeanNamesByKey(StringInterface key) {
        return instance.getBeanNamesByKey(key);
    }

    public Collection<ReferenceBeanInterface> getReferences() {
        return instance.getReferences();
    }

    public void setApplicationContext(ApplicationContextInterface applicationContext) {
        instance.setApplicationContext(applicationContext);
    }

    public void prepareReferenceBeans() {
        instance.prepareReferenceBeans();
    }

    protected ReferenceBeanManagerInterface instance;
}
