package com.muyi.summer.stepbystep.beans.xml;

import com.muyi.summer.stepbystep.beans.AbstractBeanDefinitionReader;
import com.muyi.summer.stepbystep.beans.BeanDefinition;
import com.muyi.summer.stepbystep.BeanReference;
import com.muyi.summer.stepbystep.beans.PropertyValue;
import com.muyi.summer.stepbystep.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:22 2018/1/31
 * @Description: 具体实现了 loadBeanDefinitions() 方法，从 XML 文件中读取类定义。
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        //解析bean
        registerBeanDefinitions(document);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document document) {
        Element root = document.getDocumentElement();

        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) {

        NodeList nodeList = root.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Element element = (Element) node;
                processBeanDefinition(element);
            }
        }
    }

    protected void processBeanDefinition(Element element) {
        //将name -> id
        String name = element.getAttribute("id");
        String clazz = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element, beanDefinition);
        beanDefinition.setBeanClassName(clazz);
        getRegistry().put(name, beanDefinition);

    }

    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList propertyNodeList = element.getElementsByTagName("property");
        for (int i = 0; i < propertyNodeList.getLength(); i++) {

            Node node = propertyNodeList.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;

                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");

                if (value != null && value.length() > 0){
                    beanDefinition.getBeanProperties().addProperty(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                        + name + "' must specify a ref or value");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getBeanProperties().addProperty(new PropertyValue(name, beanReference));

                }


            }
        }
    }


}
