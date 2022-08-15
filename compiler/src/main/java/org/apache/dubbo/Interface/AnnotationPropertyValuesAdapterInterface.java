package org.apache.dubbo.Interface;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValue[];
import org.springframework.beans.PropertyValues;

public interface AnnotationPropertyValuesAdapterInterface extends Object, org.springframework.beans.PropertyValues{
    PropertyValue getPropertyValues();
    PropertyValue getPropertyValue(String propertyName);
    PropertyValues changesSince(PropertyValues old);
    boolean contains(String propertyName);
    boolean isEmpty();
}