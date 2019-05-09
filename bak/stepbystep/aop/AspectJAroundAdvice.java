package com.muyi.summer.stepbystep.aop;

import com.muyi.summer.stepbystep.beans.factory.BeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/6 下午4:40
 * @Description:
 */
public class AspectJAroundAdvice implements Advice,MethodInterceptor {

    private BeanFactory beanFactory;

    private Method aspectJAdviceMethod;

    private String aspectJInstanceName;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return this.aspectJAdviceMethod.invoke(this.beanFactory.getBean(aspectJInstanceName),methodInvocation);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Method getAspectJAdviceMethod() {
        return aspectJAdviceMethod;
    }

    public void setAspectJAdviceMethod(Method aspectJAdviceMethod) {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
    }

    public String getAspectJInstanceName() {
        return aspectJInstanceName;
    }

    public void setAspectJInstanceName(String aspectJInstanceName) {
        this.aspectJInstanceName = aspectJInstanceName;
    }
}
