package org.apache.dubbo.metadata.definition.model;

import java.io.Serializable;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class MethodDefinition implements MethodDefinitionInterface {

    public StringInterface getName() {
        return instance.getName();
    }

    public List<TypeDefinitionInterface> getParameters() {
        return instance.getParameters();
    }

    public StringInterface[] getParameterTypes() {
        return instance.getParameterTypes();
    }

    public StringInterface getReturnType() {
        return instance.getReturnType();
    }

    public void setName(StringInterface name) {
        instance.setName(name);
    }

    public void setParameters(List<TypeDefinitionInterface> parameters) {
        instance.setParameters(parameters);
    }

    public void setParameterTypes(StringInterface[] parameterTypes) {
        instance.setParameterTypes(parameterTypes);
    }

    public void setReturnType(StringInterface returnType) {
        instance.setReturnType(returnType);
    }

    public List<String> getAnnotations() {
        return instance.getAnnotations();
    }

    public void setAnnotations(List<String> annotations) {
        instance.setAnnotations(annotations);
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

    protected MethodDefinitionInterface instance;
}
