package org.apache.dubbo.config.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.config.BeanDefinition;
import org.w3c.dom.Element;
import org.springframework.beans.factory.xml.ParserContext;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class DubboNamespaceHandler extends NamespaceHandlerSupport implements DubboNamespaceHandlerInterface {

    public void init() {
        instance.init();
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return instance.parse(element, parserContext);
    }

    protected DubboNamespaceHandlerInterface instance;

    public DubboNamespaceHandlerInterface getInternalInstance() {
        return instance;
    }

    protected DubboNamespaceHandler() {
        instance = (DubboNamespaceHandlerInterface) DubboClassLoader.getInstance(DubboNamespaceHandler.class.getName());
        super.instance = instance;
    }
}
