package org.apache.dubbo.Interface;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValue[];
import org.springframework.beans.PropertyValues;

public interface AnnotationPropertyValuesAdapterInterface {
    PropertyValue getPropertyValues();
    PropertyValue getPropertyValue(String propertyName);
    PropertyValues changesSince(PropertyValues old);
    boolean contains(String propertyName);
    boolean isEmpty();
}