package org.apache.dubbo.Interface

<#list importPackages as package>
import ${package}
</#list>

public interface ${className}Interface<#if isGenerics == true ><T></#if>{
    <#list methods as method>
    ${method.returnType} ${method.name}(<#list method.parameters as parameter>${parameter.type} ${parameter.name} </#list>);
    </#list>

}