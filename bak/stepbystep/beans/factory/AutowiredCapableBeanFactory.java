package com.muyi.summer.stepbystep.beans.factory;

import com.muyi.summer.stepbystep.beans.BeanDefinition;
import com.muyi.summer.stepbystep.BeanReference;
import com.muyi.summer.stepbystep.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * @Author: muyi-corp
 * @Date: Created in 20:09 2018/1/30
 * @Description:
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {

    // 这些内容已经提到了AbstractBeanFactory
//    @Override
//    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
//
//        Object bean = this.createBeanInstance(beanDefinition);
//        beanDefinition.setBean(bean);
//        this.applyBeanProperties(bean, beanDefinition);
//        return bean;
//    }
//
//
//    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
//        return beanDefinition.getBeanClass().newInstance();
//    }

    protected void applyBeanProperties(Object bean, BeanDefinition bd) throws Exception{
        for (PropertyValue propertyValue : bd.getBeanProperties().getPropertyValueList()){
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);

            //在这里将引用类型的bean创建出来
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                value = this.getBean(beanReference.getName());
            }

            //? 这里只有拥有set方法的才可以注入？ 好像不是
            declaredField.set(bean, value);
        }

    }
}
