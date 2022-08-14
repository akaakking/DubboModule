package org.apache.dubbo.Interface;

import ;
import org.w3c.dom;

public interface DubboBeanDefinitionParserInterface{
    org.springframework.beans.factory.config.BeanDefinition parse(Element element, org.springframework.beans.factory.xml.ParserContext parserContext);

}