package muyi.tiny.spring.beans.factory;

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

    public ValueHolder getArgumentValue(int index, Class<?> type, String name, Set<ValueHolder> used) {

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
