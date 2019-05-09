package com.muyi.summer.stepbystep.beans;

/**
 * @Author: muyi-corp
 * @Date: Created in 11:11 2018/1/31
 * @Description: bean的属性
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
