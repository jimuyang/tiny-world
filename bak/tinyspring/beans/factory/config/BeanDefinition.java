package com.muyi.summer.tinyspring.beans.factory.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.lang.Nullable;

/**
 * Created with IntelliJ IDEA.
 * User: muyi
 * Date: 2018/3/30
 * Description:
 *      A BeanDefinition describes a bean instance,
 *      which has property values, constructor argument values, and further information
 *      supplied by concrete implementations.
 *
 *      copy自spring 目前还没有应用在项目中
 */
public interface BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";
    int ROLE_APPLICATION = 0;
    int ROLE_SUPPORT = 1;
    int ROLE_INFRASTRUCTURE = 2;

    void setParentName(@Nullable String var1);

    @Nullable
    String getParentName();

    void setBeanClassName(@Nullable String var1);

    @Nullable
    String getBeanClassName();

    void setScope(@Nullable String var1);

    @Nullable
    String getScope();

    void setLazyInit(boolean var1);

    boolean isLazyInit();

    void setDependsOn(@Nullable String... var1);

    @Nullable
    String[] getDependsOn();

    void setAutowireCandidate(boolean var1);

    boolean isAutowireCandidate();

    void setPrimary(boolean var1);

    boolean isPrimary();

    void setFactoryBeanName(@Nullable String var1);

    @Nullable
    String getFactoryBeanName();

    void setFactoryMethodName(@Nullable String var1);

    MutablePropertyValues getPropertyValues();

    default boolean hasPropertyValues() {
        return !this.getPropertyValues().isEmpty();
    }

    boolean isSingleton();

    boolean isPrototype();

    boolean isAbstract();

    int getRole();

    @Nullable
    String getDescription();

    @Nullable
    String getResourceDescription();

    @Nullable
    org.springframework.beans.factory.config.BeanDefinition getOriginatingBeanDefinition();



}
