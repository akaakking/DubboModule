package org.apache.dubbo.Interface;

import ;
import java.lang;

public interface AnnotationPropertyValuesAdapterInterface{
    org.springframework.beans.PropertyValue getPropertyValues();
    org.springframework.beans.PropertyValue getPropertyValue(String propertyName);
    org.springframework.beans.PropertyValues changesSince(org.springframework.beans.PropertyValues old);
    boolean contains(String propertyName);
    boolean isEmpty();

}