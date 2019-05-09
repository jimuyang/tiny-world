package com.muyi.summer.stepbystep.context;

import com.muyi.summer.stepbystep.beans.BeanDefinition;
import com.muyi.summer.stepbystep.beans.factory.AbstractBeanFactory;
import com.muyi.summer.stepbystep.beans.factory.AutowiredCapableBeanFactory;
import com.muyi.summer.stepbystep.beans.io.ResourceLoader;
import com.muyi.summer.stepbystep.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Author: muyi-corp
 * @Date: Created in 23:36 2018/2/4
 * @Description:
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception{
        super(beanFactory);
        this.configLocation = configLocation;
        this.refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation,new AutowiredCapableBeanFactory());
    }

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(this.configLocation);

        for (Map.Entry<String,BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }


}
