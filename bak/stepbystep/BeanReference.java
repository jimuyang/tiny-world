package com.muyi.summer.stepbystep;

/**
 * @Author: muyi-corp
 * @Date: Created in 18:16 2018/2/1
 * @Description: 存储一个
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }


}
