package com.muyi.summer.stepbystep.aop;

/**
 * @Author: muyi-corp
 * @Date: Created in 0:12 2018/2/5
 * @Description: 被代理的对象
 */
public class TargetSource {

    private Class<?>[] targetClass;

    private Object target;

    public TargetSource(Object target, Class<?>... targetClass){
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class<?>[] getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }


}
