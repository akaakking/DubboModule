package org.apache.dubbo.config.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.config.BeanDefinition;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboNamespaceHandler extends NamespaceHandlerSupport implements DubboNamespaceHandlerInterface {

    public void init() {
        instance.init();
    }

    public BeanDefinitionInterface parse(ElementInterface element, ParserContextInterface parserContext) {
        return instance.parse(element, parserContext);
    }
}
