package org.apache.dubbo.Interface;

import java.lang;

public interface ArgumentBuilderInterface{
    ArgumentBuilderInterface index(Integer index);
    ArgumentBuilderInterface type(String type);
    ArgumentBuilderInterface callback(Boolean callback);
    ArgumentConfigInterface build();

}