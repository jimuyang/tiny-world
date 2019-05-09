package com.muyi.summer.stepbystep.beans.factory;

import com.muyi.summer.stepbystep.beans.BeanDefinition;

/**
 * @Author: muyi-corp
 * @Date: Created in 19:12 2018/1/30
 * @Description: 接口 一个IoC bean容器 可以获得bean 对象
 */
public interface BeanFactory {

    // 通过bean的name获得bean
    Object getBean(String beanName) throws Exception;

    //void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
