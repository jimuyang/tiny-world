package muyi.tiny.spring.beans;

import muyi.tiny.spring.beans.factory.ConstructorArgumentValues;
import muyi.tiny.spring.util.ClassUtil;
import org.springframework.util.ClassUtils;

/**
 * @author: Yang Fan
 * @date: 2019-05-15
 * @desc:
 */
public class GenericBeanDefinition implements BeanDefinition {

    /**
     * bean的类型 string|class
     */
    private volatile Object beanClass;

    /**
     * singleton|prototype
     */
    private String scope = SCOPE_SINGLETON;

    /**
     * 懒加载
     */
    private boolean lazyInit = false;

    /**
     * 依赖的bean names
     */
    private String[] dependsOn;

    /**
     * 构造函数参数列表
     */
    private ConstructorArgumentValues constructorArgumentValues;

    /**
     * 属性值
     */
    private MutablePropertyValues propertyValues;

    /**
     * 初始化bean时执行
     */
    private String initMethodName;

    /**
     * 销毁bean时执行
     */
    private String destroyMethodName;

    /**
     * 描述
     */
    private String description;

    /**
     * bean定义继承自
     */
    private String parentName;

    protected GenericBeanDefinition() {
        this(null, null);
    }

    protected GenericBeanDefinition(ConstructorArgumentValues cargs, MutablePropertyValues pvs) {
        this.constructorArgumentValues = cargs;
        this.propertyValues = pvs;
    }


    @Override
    public void setBeanClassName(String beanClassName) {
        this.beanClass = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject instanceof Class) {
            return ((Class<?>) beanClassObject).getName();
        } else {
            return (String) beanClassObject;
        }
    }

    public Class<?> getBeanClass() throws IllegalStateException {
        if (this.beanClass == null) {
            throw new IllegalStateException("no bean class specified");
        }
        // ? when resolved beanClassName to actual class
        if (!(this.beanClass instanceof Class)) {
            throw new IllegalStateException(
                    "Bean class name [" + this.beanClass + "] has not been resolved into an actual Class");
        }
        return (Class<?>) this.beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public boolean hasBeanClass() {
        return (this.beanClass instanceof Class);
    }

    public Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException {
        String className = this.getBeanClassName();
        if (className == null) {
            return null;
        }
        Class<?> resolvedClass = ClassUtil.forName(className, classLoader);
        this.beanClass = resolvedClass;
        return resolvedClass;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(this.scope);
    }

    public boolean isPrototype() {
        return SCOPE_PROTOTYPE.equals(this.scope);
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
    public void setDependsOn(String... dependsOn) {
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

    @Override
    public String getParentName() {
        return parentName;
    }

    @Override
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public ConstructorArgumentValues getConstructorArgumentValues() {
        if (this.constructorArgumentValues == null) {
            this.constructorArgumentValues = new ConstructorArgumentValues();
        }
        return this.constructorArgumentValues;
    }

    public void setConstructorArgumentValues(ConstructorArgumentValues constructorArgumentValues) {
        this.constructorArgumentValues = constructorArgumentValues;
    }

    @Override
    public MutablePropertyValues getPropertyValues() {
        if (this.propertyValues == null) {
            this.propertyValues = new MutablePropertyValues();
        }
        return this.propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
