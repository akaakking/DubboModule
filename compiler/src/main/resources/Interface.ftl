package org.apache.dubbo.Interface;

<#list importPackages as package>
<#if package != "">
import ${package};
</#if>
</#list>

public interface ${classTypeName} <#if hasSuper == true>extends </#if><#list parents as parent>${parent}<#if parent_has_next == true>, </#if></#list>{
    <#list methods as method>
    ${method.returnType} ${method.name}(<#list method.parameters as parameter>${parameter.type} ${parameter.name}<#if parameter_has_next == true>, </#if></#list>);
    </#list>
}