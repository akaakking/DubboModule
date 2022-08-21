package org.apache.dubbo.config.spring.beans.factory.annotation;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.PropertyValue;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.util.Map;
import org.springframework.core.env.PropertyResolver;

public class AnnotationPropertyValuesAdapter implements AnnotationPropertyValuesAdapterInterface {

    public PropertyValue[] getPropertyValues() {
        return instance.getPropertyValues();
    }

    public PropertyValue getPropertyValue(String propertyName) {
        return instance.getPropertyValue(propertyName);
    }

    public PropertyValues changesSince(PropertyValues old) {
        return instance.changesSince(old);
    }

    public boolean contains(String propertyName) {
        return instance.contains(propertyName);
    }

    public boolean isEmpty() {
        return instance.isEmpty();
    }

    protected AnnotationPropertyValuesAdapterInterface instance;

    public AnnotationPropertyValuesAdapterInterface getInternalInstance() {
        return instance;
    }

    public AnnotationPropertyValuesAdapter(Map<String, Object> attributes, PropertyResolver propertyResolver, String ignoreAttributeNames) {
        Class[] params = new Class[]{MapMap<String,Object>.class, PropertyResolver.class, String.class};
        Object[] args = new Object[]{attributes, propertyResolver, ignoreAttributeNames};
        instance = (AnnotationPropertyValuesAdapterInterface) DubboClassLoader.getInstance(AnnotationPropertyValuesAdapter.class.getName(), params, args);
    }

    public AnnotationPropertyValuesAdapter(Annotation annotation, PropertyResolver propertyResolver, boolean ignoreDefaultValue, String ignoreAttributeNames) {
        Class[] params = new Class[]{Annotation.class, PropertyResolver.class, boolean.class, String.class};
        Object[] args = new Object[]{annotation, propertyResolver, ignoreDefaultValue, ignoreAttributeNames};
        instance = (AnnotationPropertyValuesAdapterInterface) DubboClassLoader.getInstance(AnnotationPropertyValuesAdapter.class.getName(), params, args);
    }

    public AnnotationPropertyValuesAdapter(Annotation annotation, PropertyResolver propertyResolver, String ignoreAttributeNames) {
        Class[] params = new Class[]{Annotation.class, PropertyResolver.class, String.class};
        Object[] args = new Object[]{annotation, propertyResolver, ignoreAttributeNames};
        instance = (AnnotationPropertyValuesAdapterInterface) DubboClassLoader.getInstance(AnnotationPropertyValuesAdapter.class.getName(), params, args);
    }

    protected AnnotationPropertyValuesAdapter() {
        instance = (AnnotationPropertyValuesAdapterInterface) DubboClassLoader.getInstance(AnnotationPropertyValuesAdapter.class.getName());
    }
}
