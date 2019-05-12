package muyi.tiny.spring.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Yang Fan
 * @date: 2019-05-12
 * @desc:
 */
public class MutablePropertyValues implements PropertyValues, Serializable {

    private final List<PropertyValue> propertyValueList;

    private Set<String> processedProperties;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<PropertyValue>(0);
    }

    public MutablePropertyValues(Map<?, ?> original) {
        if (original != null) {
            this.propertyValueList = new ArrayList<>(original.size());
            original.forEach((attrName, attrValue) -> this.propertyValueList.add(
                    new PropertyValue(attrName.toString(), attrValue)));
        } else {
            this.propertyValueList = new ArrayList<>(0);
        }
    }

    public MutablePropertyValues addPropertyValue(PropertyValue pv) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue existPv = this.propertyValueList.get(i);
            if (existPv.getName().equals(pv.getName())) {
                this.propertyValueList.set(i, pv);
                return this;
            }
        }

        this.propertyValueList.add(pv);
        return this;
    }

    @Override
    public PropertyValue[] getPropertyValues() {
        return new PropertyValue[0];
    }

    @Override
    public PropertyValue getPropertyValue(String propertyName) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(String propertyName) {
        return false;
    }
}
