package com.muyi.summer.stepbystep.aop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/4 下午11:20
 * @Description:
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
