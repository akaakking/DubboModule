package org.apache.dubbo.config.spring.schema;

import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class AnnotationBeanDefinitionParser extends AbstractSingleBeanDefinitionParser implements AnnotationBeanDefinitionParserInterface {

    protected AnnotationBeanDefinitionParserInterface instance;

    public AnnotationBeanDefinitionParserInterface getInternalInstance() {
        return instance;
    }

    protected AnnotationBeanDefinitionParser() {
        instance = (AnnotationBeanDefinitionParserInterface) DubboClassLoader.getInstance(AnnotationBeanDefinitionParser.class.getName());
        super.instance = this.instance;
    }
}
