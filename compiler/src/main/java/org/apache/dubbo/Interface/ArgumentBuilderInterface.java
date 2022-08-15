package org.apache.dubbo.Interface;


public interface ArgumentBuilderInterface extends Object{
    ArgumentBuilderInterface index(Integer index);
    ArgumentBuilderInterface type(String type);
    ArgumentBuilderInterface callback(Boolean callback);
    ArgumentConfigInterface build();
}