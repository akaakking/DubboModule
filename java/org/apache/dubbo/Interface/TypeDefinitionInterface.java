package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Object;

public interface TypeDefinitionInterface extends Serializable {

    List<String> getEnums();

    List<String> getItems();

    Map<String, String> getProperties();

    String getType();

    void setEnums(List<String> enums);

    void setItems(List<String> items);

    void setProperties(Map<String, String> properties);

    void setType(String type);

    String toString();

    boolean equals(Object o);

    int hashCode();
}
