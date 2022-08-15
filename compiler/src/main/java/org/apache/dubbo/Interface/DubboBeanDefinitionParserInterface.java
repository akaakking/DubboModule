package org.apache.dubbo.Interface;

import org.w3c.dom.Element;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.config.BeanDefinition;

public interface DubboBeanDefinitionParserInterface extends Object, org.springframework.beans.factory.xml.BeanDefinitionParser{
    BeanDefinition parse(Element element, ParserContext parserContext);
}