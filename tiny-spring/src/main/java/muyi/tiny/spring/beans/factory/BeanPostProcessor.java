package muyi.tiny.spring.beans.factory;

import muyi.tiny.spring.exception.BeansException;

/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc:
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
