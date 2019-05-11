package muyi.tiny.spring.beans;

/**
 * @author: Yang Fan
 * @date: 2019-05-10
 * @desc: bean的属性
 */
public class BeanProperty {

    private final String name;

    private final Object value;

    public BeanProperty(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

