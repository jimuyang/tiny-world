package com.muyi.summer.stepbystep.beans;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:12 2018/1/31
 * @Description: 从配置中读取BeanDefinition
 * 解析 BeanDefinition 的接口。通过 loadBeanDefinitions(String) 来从一个地址加载类定义。
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws Exception;
}
