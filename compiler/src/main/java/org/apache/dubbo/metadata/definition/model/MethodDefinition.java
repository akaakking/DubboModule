package org.apache.dubbo.metadata.definition.model;

import java.io.Serializable;
import java.util.List;
import java.lang.String;
import java.lang.Object;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MethodDefinition implements MethodDefinitionInterface {

    public String getName() {
        return instance.getName();
    }

    public List<TypeDefinitionInterface> getParameters() {
        return instance.getParameters();
    }

    public String[] getParameterTypes() {
        return instance.getParameterTypes();
    }

    public String getReturnType() {
        return instance.getReturnType();
    }

    public void setName(String name) {
        instance.setName(name);
    }

    public void setParameters(List<TypeDefinitionInterface> parameters) {
        instance.setParameters(parameters);
    }

    public void setParameterTypes(String[] parameterTypes) {
        instance.setParameterTypes(parameterTypes);
    }

    public void setReturnType(String returnType) {
        instance.setReturnType(returnType);
    }

    public List<String> getAnnotations() {
        return instance.getAnnotations();
    }

    public void setAnnotations(List<String> annotations) {
        instance.setAnnotations(annotations);
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

    protected MethodDefinitionInterface instance;

    public MethodDefinitionInterface getInternalInstance() {
        return instance;
    }

    protected MethodDefinition() {
        instance = (MethodDefinitionInterface) DubboClassLoader.getInstance(MethodDefinition.class.getName());
    }
}
