package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.lang.String;
import java.util.Map;
import java.util.List;
import java.util.Set;
import org.apache.dubbo.Interface.RequestMetadataInterface;
import java.lang.Object;

public interface RequestMetadataInterface extends Serializable {

    String getMethod();

    void setMethod(String method);

    String getPath();

    void setPath(String path);

    Map<String, List<String>> getParams();

    void setParams(Map<String, List<String>> params);

    Map<String, List<String>> getHeaders();

    void setHeaders(Map<String, List<String>> headers);

    Set<String> getConsumes();

    void setConsumes(Set<String> consumes);

    Set<String> getProduces();

    void setProduces(Set<String> produces);

    Set<String> getParamNames();

    Set<String> getHeaderNames();

    String getParameter(String name);

    String getHeader(String name);

    RequestMetadataInterface addParam(String name, String value);

    RequestMetadataInterface addHeader(String name, String value);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
