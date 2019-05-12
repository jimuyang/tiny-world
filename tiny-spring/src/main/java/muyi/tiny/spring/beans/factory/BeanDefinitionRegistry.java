package muyi.tiny.spring.beans.factory;

import muyi.tiny.spring.beans.BeanDefinition;

/**
 * Interface for registries that hold bean definitions, for example RootBeanDefinition
 * and ChildBeanDefinition instances. Typically implemented by BeanFactories that
 * internally work with the AbstractBeanDefinition hierarchy.
 *
 * @author: Yang Fan
 * @date: 2019-05-12
 */
public interface BeanDefinitionRegistry {


    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
