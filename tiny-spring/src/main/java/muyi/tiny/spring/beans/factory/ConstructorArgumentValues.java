package muyi.tiny.spring.beans.factory;

import muyi.tiny.spring.util.StringUtil;

import java.util.*;

/**
 * @author: Yang Fan
 * @date: 2019-05-13
 * @desc:
 */
public class ConstructorArgumentValues {

    private final Map<Integer, ValueHolder> indexedArgumentValues = new LinkedHashMap<>();

    private final List<ValueHolder> genericArgumentValues = new ArrayList<>();


    public void addIndexedArgumentValue(Integer key, ValueHolder newValue) {
        this.indexedArgumentValues.put(key, newValue);
    }

    public void addGenericArgumentValue(Object value) {
        this.genericArgumentValues.add(new ValueHolder(value));
    }

    public void clear() {
        this.indexedArgumentValues.clear();
        this.genericArgumentValues.clear();
    }

    public int getArgumentCount() {
        return this.indexedArgumentValues.size() + this.genericArgumentValues.size();
    }


    public ValueHolder getIndexedArgumentValue(int index, Class<?> requiredType, String requiredName) {
        ValueHolder valueHolder = this.indexedArgumentValues.get(index);
        if (StringUtil.notEmpty(requiredName) && !requiredName.equals(valueHolder.getName())) {
            return null;
        }
        if (requiredType != null && !requiredType.getName().equals(valueHolder.getType())) {
            return null;
        }
        return valueHolder;
    }

    public ValueHolder getGenericArgumentValue(Class<?> requiredType, String requiredName, Set<ValueHolder> used) {
        for (ValueHolder valueHolder : this.genericArgumentValues) {
            if (used != null && used.contains(valueHolder)) {
                continue;
            }
            if (requiredType != null && !requiredType.getName().equals(valueHolder.getType())) {
                continue;
            }
            if (requiredName != null && !requiredName.equals(valueHolder.getName())) {
                continue;
            }
            return valueHolder;
        }
        return null;
    }

    public ValueHolder getArgumentValue(int index, Class<?> requiredType, String requiredName, Set<ValueHolder> used) {
        ValueHolder valueHolder = getIndexedArgumentValue(index, requiredType, requiredName);
        if (valueHolder == null) {
            valueHolder = getGenericArgumentValue(requiredType, requiredName, used);
        }
        return valueHolder;
    }


    public static class ValueHolder {

        private Object value;

        private String type;

        private String name;

        public ValueHolder(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
