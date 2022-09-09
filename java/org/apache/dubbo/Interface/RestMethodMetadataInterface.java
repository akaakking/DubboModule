package org.apache.dubbo.Interface;

import java.io.Serializable;
import org.apache.dubbo.Interface.MethodDefinitionInterface;
import org.apache.dubbo.metadata.definition.model.MethodDefinition;
import org.apache.dubbo.Interface.RequestMetadataInterface;
import org.apache.dubbo.metadata.rest.RequestMetadata;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Collection;
import java.util.List;
import java.lang.Object;

public interface RestMethodMetadataInterface extends Serializable {

    MethodDefinitionInterface getMethod();

    void setMethod(MethodDefinitionInterface method);

    RequestMetadataInterface getRequest();

    void setRequest(RequestMetadataInterface request);

    Integer getUrlIndex();

    void setUrlIndex(Integer urlIndex);

    Integer getBodyIndex();

    void setBodyIndex(Integer bodyIndex);

    Integer getHeaderMapIndex();

    void setHeaderMapIndex(Integer headerMapIndex);

    String getBodyType();

    void setBodyType(String bodyType);

    Map<Integer, Collection<String>> getIndexToName();

    void setIndexToName(Map<Integer, Collection<String>> indexToName);

    void addIndexToName(Integer index, String name);

    boolean hasIndexedName(Integer index, String name);

    List<String> getFormParams();

    void setFormParams(List<String> formParams);

    Map<Integer, Boolean> getIndexToEncoded();

    void setIndexToEncoded(Map<Integer, Boolean> indexToEncoded);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
