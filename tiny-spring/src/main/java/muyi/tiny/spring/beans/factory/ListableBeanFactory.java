package muyi.tiny.spring.beans.factory;

import muyi.tiny.spring.core.ResolvableType;
import muyi.tiny.spring.exception.BeansException;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc:
 */
public interface ListableBeanFactory extends BeanFactory {

    boolean containsBeanDefinition(String beanName);

    int getBeanDefinitionCount();

//    String[] getBeanNamesForType(ResolvableType type);

    String[] getBeanNamesForType(Class<?> type);

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) throws BeansException;
}
