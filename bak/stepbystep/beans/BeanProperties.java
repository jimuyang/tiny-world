package com.muyi.summer.stepbystep.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: muyi-corp
 * @Date: Created in 11:13 2018/1/31
 * @Description: bean的属性列表
 * 包装一个对象所有的PropertyValue。
 */
public class BeanProperties {


    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public BeanProperties(){

    }

    public void addProperty(PropertyValue pv){
        // 这里可以对重复的propertyName 进行筛选
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
