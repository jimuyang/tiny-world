package muyi.tiny.spring.beans.factory;

/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc:
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();

    int getSingletonCount();

    Object getSingletonMutex();

}
