package com.muyi.summer.stepbystep;

import com.muyi.summer.stepbystep.beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:20 2018/1/30
 * @Description: 最简单的beanFactory
 */
@Deprecated
public class BeanFactory {


    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        return this.beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(name, beanDefinition);
    }

}
