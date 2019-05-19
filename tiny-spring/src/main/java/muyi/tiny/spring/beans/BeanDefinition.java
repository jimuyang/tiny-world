package muyi.tiny.spring.beans;

import muyi.tiny.spring.beans.factory.ConstructorArgumentValues;

/**
 * @author: Yang Fan
 * @date: 2019-05-12
 * @desc:
 */
public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";


    /**
     * parent definition
     */
    void setParentName(String parentName);

    String getParentName();

    /**
     * bean class
     */
    void setBeanClassName(String beanClassName);

    String getBeanClassName();

    /**
     * bean scope: SINGLETON/PROTOTYPE
     */
    void setScope(String scope);

    String getScope();

    /**
     * 懒加载
     */
    void setLazyInit(boolean lazyInit);

    boolean isLazyInit();

    /**
     * 依赖的bean
     * The bean factory will guarantee that these beans get initialized first.
     */
    void setDependsOn(String... dependBeans);

    String[] getDependsOn();


    void setDescription(String description);

    String getDescription();

    ConstructorArgumentValues getConstructorArgumentValues();

    MutablePropertyValues getPropertyValues();



}
