package org.apache.dubbo.metadata.definition.model;

import java.io.Serializable;
import java.util.List;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class ServiceDefinition implements ServiceDefinitionInterface {

    public StringInterface getCanonicalName() {
        return instance.getCanonicalName();
    }

    public StringInterface getCodeSource() {
        return instance.getCodeSource();
    }

    public List<MethodDefinitionInterface> getMethods() {
        return instance.getMethods();
    }

    public List<TypeDefinitionInterface> getTypes() {
        return instance.getTypes();
    }

    public StringInterface getUniqueId() {
        return instance.getUniqueId();
    }

    public void setCanonicalName(StringInterface canonicalName) {
        instance.setCanonicalName(canonicalName);
    }

    public void setCodeSource(StringInterface codeSource) {
        instance.setCodeSource(codeSource);
    }

    public void setMethods(List<MethodDefinitionInterface> methods) {
        instance.setMethods(methods);
    }

    public void setTypes(List<TypeDefinitionInterface> types) {
        instance.setTypes(types);
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

    protected ServiceDefinitionInterface instance;
}
