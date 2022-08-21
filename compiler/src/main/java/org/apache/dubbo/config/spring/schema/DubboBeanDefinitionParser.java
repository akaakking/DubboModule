package org.apache.dubbo.config.spring.schema;

import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.config.BeanDefinition;
import org.w3c.dom.Element;
import org.springframework.beans.factory.xml.ParserContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBeanDefinitionParser implements DubboBeanDefinitionParserInterface {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return instance.parse(element, parserContext);
    }

    protected DubboBeanDefinitionParserInterface instance;

    public DubboBeanDefinitionParserInterface getInternalInstance() {
        return instance;
    }

    public DubboBeanDefinitionParser(Class<?> beanClass) {
        Class[] params = new Class[]{ClassClass<?>.class};
        Object[] args = new Object[]{beanClass};
        instance = (DubboBeanDefinitionParserInterface) DubboClassLoader.getInstance(DubboBeanDefinitionParser.class.getName(), params, args);
    }

    protected DubboBeanDefinitionParser() {
        instance = (DubboBeanDefinitionParserInterface) DubboClassLoader.getInstance(DubboBeanDefinitionParser.class.getName());
    }
}
