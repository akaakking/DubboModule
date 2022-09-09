package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.util.List;
import org.apache.dubbo.Interface.TypeDefinitionInterface;
import java.lang.String;
import java.lang.Object;

public interface MethodDefinitionInterface extends Serializable {

    String getName();

    List<TypeDefinitionInterface> getParameters();

    String[] getParameterTypes();

    String getReturnType();

    void setName(String name);

    void setParameters(List<TypeDefinitionInterface> parameters);

    void setParameterTypes(String[] parameterTypes);

    void setReturnType(String returnType);

    List<String> getAnnotations();

    void setAnnotations(List<String> annotations);

    String toString();

    boolean equals(Object o);

    int hashCode();
}
