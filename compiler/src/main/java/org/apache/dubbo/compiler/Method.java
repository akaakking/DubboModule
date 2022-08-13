package org.apache.dubbo.compiler;

import java.util.List;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/13 下午4:59
 */
public class Method {
    String name;
    String returnType;
    List<Parameter> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
