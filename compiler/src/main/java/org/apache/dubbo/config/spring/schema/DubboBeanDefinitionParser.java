package org.apache.dubbo.config.spring.schema;

import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.config.BeanDefinition;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboBeanDefinitionParser implements DubboBeanDefinitionParserInterface {

    public BeanDefinitionInterface parse(ElementInterface element, ParserContextInterface parserContext) {
        return instance.parse(element, parserContext);
    }

    protected DubboBeanDefinitionParserInterface instance;

    public DubboBeanDefinitionParser(Class<?> beanClass) {
        Class[] params = new Class[]{ClassClass<?>.class};
        Object[] args = new Object[]{beanClass};
        instance = (DubboBeanDefinitionParserInterface) DubboClassLoader.getInstance(DubboBeanDefinitionParser.class.getName(), params, args);
    }
}
