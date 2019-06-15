package muyi.tiny.pylon.core.config.handler;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author: Yang Fan
 * @date: 2019-06-15
 * @desc:
 */
public class DemoNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return super.parse(element, parserContext);
    }

    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder definition, ParserContext parserContext) {
        return super.decorate(node, definition, parserContext);
    }

    @Override
    public void init() {
        registerBeanDefinitionParser("muyi", new DemoBeanDefinitionParser());
    }
}
