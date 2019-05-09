package com.muyi.summer.stepbystep.aop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/4 下午11:16
 * @Description:
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}
