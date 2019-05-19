package muyi.tiny.spring.beans.factory;


import muyi.tiny.spring.exception.BeansException;

/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc:
 */
public interface ConfigurableBeanFactory extends SingletonBeanRegistry, BeanFactory {

    void setBeanClassLoader(ClassLoader beanClassLoader);

    ClassLoader getBeanClassLoader();

    //?
    void setTempClassLoader(ClassLoader tempClassLoader);

    ClassLoader getTempClassLoader();

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void registerAlias(String beanName, String alias) throws BeansException;

    void registerDependentBean(String beanName, String dependentBeanName);

    String[] getDependentBeans(String beanName);

    String[] getDependenciesForBean(String beanName);

    void destroyBean(String beanName, Object beanInstance);

}
