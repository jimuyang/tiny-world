package muyi.tiny.spring.beans;


import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 * @author: Yang Fan
 * @date: 2019-05-12
 * @desc:
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

    private volatile Object beanClass;

    private String scope = "";

    private boolean lazyInit = false;

    private String[] dependsOn;

    private ConstructorArgumentValues constructorArgumentValues;

    private String initMethodName;

    private String destroyMethodName;

    private String description;

    /**
     * Specify the bean class name of this bean definition.
     */
    @Override
    public void setBeanClassName(String beanClassName) {
        this.beanClass = beanClassName;
    }

    /**
     * Return the current bean class name of this bean definition.
     */
    @Override
    public String getBeanClassName() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject instanceof Class) {
            return ((Class<?>) beanClassObject).getName();
        } else {
            return (String) beanClassObject;
        }
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean isLazyInit() {
        return lazyInit;
    }

    @Override
    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    @Override
    public String[] getDependsOn() {
        return dependsOn;
    }

    @Override
    public void setDependsOn(String[] dependsOn) {
        this.dependsOn = dependsOn;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
