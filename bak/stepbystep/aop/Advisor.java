package com.muyi.summer.stepbystep.aop;

import org.aopalliance.aop.Advice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/4 下午11:19
 * @Description:
 */
public interface Advisor {
    Advice getAdvice();
}
