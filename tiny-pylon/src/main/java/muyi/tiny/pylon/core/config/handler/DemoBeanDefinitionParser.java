package muyi.tiny.pylon.core.config.handler;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author: Yang Fan
 * @date: 2019-06-15
 * @desc:
 */
public class DemoBeanDefinitionParser extends AbstractBeanDefinitionParser implements BeanDefinitionParser {


    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(DemoBeanDefinition.class);
        builder.addPropertyValue("name", element.getAttribute("name"));
        builder.addPropertyValue("age", element.getAttribute("age"));
        builder.addPropertyValue("sex", element.getAttribute("sex"));
        return builder.getBeanDefinition();
    }
}
