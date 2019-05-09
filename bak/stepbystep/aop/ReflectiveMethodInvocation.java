package com.muyi.summer.stepbystep.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @Author: muyi-corp
 * @Date: Created in 10:46 2018/2/6
 * @Description:
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Object target;

    private Method method;

    private Object[] args;

    public ReflectiveMethodInvocation(Object target,Method method, Object[] args){
        this.args = args;
        this.target = target;
        this.method = method;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return this.args;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(this.target,this.args);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
