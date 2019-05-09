package com.muyi.summer.stepbystep.aop;

import org.aopalliance.aop.Advice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/5 下午6:24
 * @Description:
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;


    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression){
        this.pointcut.setExpression(expression);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
