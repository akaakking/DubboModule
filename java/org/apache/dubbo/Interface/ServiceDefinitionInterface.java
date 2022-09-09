package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.util.List;
import org.apache.dubbo.Interface.MethodDefinitionInterface;
import org.apache.dubbo.Interface.TypeDefinitionInterface;
import java.lang.String;
import java.lang.Object;

public interface ServiceDefinitionInterface extends Serializable {

    String getCanonicalName();

    String getCodeSource();

    List<MethodDefinitionInterface> getMethods();

    List<TypeDefinitionInterface> getTypes();

    String getUniqueId();

    void setCanonicalName(String canonicalName);

    void setCodeSource(String codeSource);

    void setMethods(List<MethodDefinitionInterface> methods);

    void setTypes(List<TypeDefinitionInterface> types);

    List<String> getAnnotations();

    void setAnnotations(List<String> annotations);

    String toString();

    boolean equals(Object o);

    int hashCode();
}
