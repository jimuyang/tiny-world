package com.muyi.summer.stepbystep.aop;

import com.muyi.summer.stepbystep.beans.factory.BeanFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/6 下午4:45
 * @Description:
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
