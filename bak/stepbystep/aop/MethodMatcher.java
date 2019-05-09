package com.muyi.summer.stepbystep.aop;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/4 下午11:17
 * @Description:
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
