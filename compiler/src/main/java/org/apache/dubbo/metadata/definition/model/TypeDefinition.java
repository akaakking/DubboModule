package org.apache.dubbo.metadata.definition.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class TypeDefinition implements TypeDefinitionInterface {

    public List<String> getEnums() {
        return instance.getEnums();
    }

    public List<String> getItems() {
        return instance.getItems();
    }

    public Map<String, String> getProperties() {
        return instance.getProperties();
    }

    public StringInterface getType() {
        return instance.getType();
    }

    public void setEnums(List<String> enums) {
        instance.setEnums(enums);
    }

    public void setItems(List<String> items) {
        instance.setItems(items);
    }

    public void setProperties(Map<String, String> properties) {
        instance.setProperties(properties);
    }

    public void setType(StringInterface type) {
        instance.setType(type);
    }

    public StringInterface toString() {
        return instance.toString();
    }

    public boolean equals(ObjectInterface o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    protected TypeDefinitionInterface instance;

    public static StringInterface[] formatTypes(StringInterface[] types) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(formatTypes, String[].class);
        return method.invoke(types);
    }

    public static StringInterface formatType(StringInterface type) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(formatType, String.class);
        return method.invoke(type);
    }

    public TypeDefinition() {
        instance = (TypeDefinitionInterface) DubboClassLoader.getInstance(TypeDefinition.class.getName());
    }

    public TypeDefinition(String type) {
        Class[] params = new Class[]{String.class};
        Object[] args = new Object[]{type};
        instance = (TypeDefinitionInterface) DubboClassLoader.getInstance(TypeDefinition.class.getName(), params, args);
    }
}
