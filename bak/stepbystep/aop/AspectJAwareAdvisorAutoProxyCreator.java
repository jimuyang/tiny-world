package com.muyi.summer.stepbystep.aop;

import com.muyi.summer.stepbystep.beans.BeanPostProcessor;
import com.muyi.summer.stepbystep.beans.factory.AbstractBeanFactory;
import com.muyi.summer.stepbystep.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.annotation.Target;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: muyi-macpro
 * @Time: 2018/3/6 下午4:47
 * @Description:
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor,BeanFactoryAware {

    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {

        // 如果bean是PointcutAdvisor或者MethodInterceptor就直接返回这个bean
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        // 找到所有的advisor
        List<AspectJExpressionPointcutAdvisor> advisors =
                this.beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);

        // 如果匹配了这个bean就返回它的proxy
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean, bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);

                return new JdkDynamicAopProxy(advisedSupport).getProxy();
            }
        }

        return bean;
    }
}
