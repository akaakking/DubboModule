package org.apache.dubbo.Interface;

import org.w3c.dom.Element;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.config.BeanDefinition;

public interface DubboNamespaceHandlerInterface extends org.springframework.beans.factory.xml.NamespaceHandlerSupport, ConfigurableSourceBeanMetadataElement{
    void init();
    BeanDefinition parse(Element element, ParserContext parserContext);
}