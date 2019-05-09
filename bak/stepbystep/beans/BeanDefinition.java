package com.muyi.summer.stepbystep.beans;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:19 2018/1/30
 * @Description: bean的内容及元数据 保存在beanFactory中 包装bean的实体
 *
 * 里面包含了一个个 PropertyValue 条目，每个条目都是键值对 String - Object，分别对应要生成实例的属性的名字与类型。
 * 在 Spring 的 XML 中的 property 中，键是 key ，值是 value 或者 ref。
 * 对于 value 只要直接注入属性就行了，但是 ref 要先进行解析。
 * Object 如果是 BeanReference 类型，则说明其是一个引用，其中保存了引用的名字，需要用先进行解析，转化为对应的实际 Object。
 */
public class BeanDefinition {

    //单例bean的实例
    private Object bean;
    //bean的class
    private Class beanClass;
    //bean的class name
    private String beanClassName;
    //bean的所有属性
    private BeanProperties beanProperties;




    public BeanDefinition() {
        this.beanProperties = new BeanProperties();
    }

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object bean){
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public BeanProperties getBeanProperties() {
        return beanProperties;
    }

    public void setBeanProperties(BeanProperties beanProperties) {
        this.beanProperties = beanProperties;
    }
}
