//package muyi.tiny.spring.beans;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author: Yang Fan
// * @date: 2019-05-10
// * @desc:
// * @see org.springframework.beans.factory.config.BeanDefinition
// * @see org.springframework.beans.factory.support.AbstractBeanDefinition
// */
//public class BeanDefinition {
//
//    /**
//     * bean的类型
//     */
//    private final Class clazz;
//
//    /**
//     * bean的类型名称
//     */
//    private final String clazzName;
//
//    /**
//     * bean的属性
//     */
//    private final List<BeanProperty> properties;
//
//    public BeanDefinition(String clazzName) {
//        this.clazzName = clazzName;
//        try {
//            this.clazz = Class.forName(clazzName);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("cannot find bean class: " + clazzName);
//        }
//        this.properties = new ArrayList<>();
//    }
//
//    public void addProperty(BeanProperty property) {
//        this.properties.add(property);
//    }
//
//
//    public Class getClazz() {
//        return clazz;
//    }
//
//    public String getClazzName() {
//        return clazzName;
//    }
//
//    public List<BeanProperty> getProperties() {
//        return properties;
//    }
//}
//
