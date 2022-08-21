package org.apache.dubbo.metadata.definition.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;
import java.lang.reflect.Method;

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

    public String getType() {
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

    public void setType(String type) {
        instance.setType(type);
    }

    public String toString() {
        return instance.toString();
    }

    public boolean equals(Object o) {
        return instance.equals(o);
    }

    public int hashCode() {
        return instance.hashCode();
    }

    protected TypeDefinitionInterface instance;

    public static String[] formatTypes(String[] types) {
        try { 
                    Class klass = DubboClassLoader.getKlass(TypeDefinition.class.getName());
                    Method method = klass.getMethod("formatTypes", String[].class);
        return (String[])method.invoke(types);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public static String formatType(String type) {
        try { 
          Class klass = DubboClassLoader.getKlass(TypeDefinition.class.getName());
        Method method = klass.getMethod("formatType", String.class);
        return (String)method.invoke(type);
                } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        };
        return null;
    }

    public TypeDefinitionInterface getInternalInstance() {
        return instance;
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
