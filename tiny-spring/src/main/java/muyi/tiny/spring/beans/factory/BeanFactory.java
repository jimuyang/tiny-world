package muyi.tiny.spring.beans.factory;

import muyi.tiny.spring.exception.BeansException;

/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc:
 */
public interface BeanFactory {

    String FACTORY_BEAN_PREFIX = "&";

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";


    Object getBean(String name) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    boolean containsBean(String name);

    boolean isSingleton(String name) throws BeansException;

    boolean isPrototype(String name) throws BeansException;

    Class<?> getType(String name) throws BeansException;

    String[] getAliases(String name);

}
