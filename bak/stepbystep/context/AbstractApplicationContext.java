package com.muyi.summer.stepbystep.context;

import com.muyi.summer.stepbystep.beans.BeanPostProcessor;
import com.muyi.summer.stepbystep.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @Author: muyi-corp
 * @Date: Created in 23:34 2018/2/4
 * @Description:
 *
 * ApplicationContext 的抽象实现，内部包含一个 BeanFactory 类。
 * 主要方法有 getBean() 和 refresh() 方法。
 * getBean() 直接调用了内置 BeanFactory 的 getBean() 方法，
 * refresh() 则用于实现 BeanFactory 的刷新，也就是告诉 BeanFactory 该使用哪个资源（Resource）加载类定义（BeanDefinition）信息，
 * 该方法留给子类实现，用以实现 从不同来源的不同类型的资源加载类定义 的效果。
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) throws Exception{
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
        /**
         *
        ApplicationContext 完成了类定义的读取和加载，并注册到 BeanFactory 中去
        */
        this.loadBeanDefinitions(this.beanFactory);
        /*
        ApplicationContext 从 BeanFactory 中寻找 BeanPostProcessor，
        注册到 BeanFactory维护的 BeanPostProcessor 列表中去*/
        this.registerBeanPostProcessors(this.beanFactory);
        /*
        ApplicationContext 以单例的模式，通过主动调用 getBean 实例化、注入属性、
        然后初始化 BeanFactory 中所有的 Bean。
        由于所有的 BeanPostProcessor 都已经在第 2 步中完成实例化了，
        因此接下来实例化的是普通 Bean，因此普通 Bean 的初始化过程可以正常执行。
        */
        this.onRefresh();
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception{
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);

        for (Object beanPostProcessor : beanPostProcessors){
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    protected void onRefresh() throws Exception{
        this.beanFactory.preInstantiateSingletons();
    }


    @Override
    public Object getBean(String beanName) throws Exception {
        return this.beanFactory.getBean(beanName);
    }


}


