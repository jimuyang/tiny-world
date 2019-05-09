package com.muyi.summer.stepbystep.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: muyi-corp
 * @Date: Created in 10:43 2018/2/6
 * @Description:
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {


    private AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                this.advisedSupport.getTargetSource().getTargetClass(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = this.advisedSupport.getMethodInterceptor();
        return methodInterceptor.invoke(
                new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args));
    }
}
