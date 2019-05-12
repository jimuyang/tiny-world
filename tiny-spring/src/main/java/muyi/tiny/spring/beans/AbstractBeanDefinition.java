package muyi.tiny.spring.beans;


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

    private String initMethodName;

    private String destroyMethodName;

    private String description;


    public Object getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
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
