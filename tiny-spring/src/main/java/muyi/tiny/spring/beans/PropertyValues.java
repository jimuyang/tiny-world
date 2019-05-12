package muyi.tiny.spring.beans;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author: Yang Fan
 * @date: 2019-05-12
 * @desc:
 */
public interface PropertyValues extends Iterable<PropertyValue> {

    PropertyValue[] getPropertyValues();

    PropertyValue getPropertyValue(String propertyName);

    boolean isEmpty();

    boolean contains(String propertyName);

    @Override
    default Iterator<PropertyValue> iterator() {
        return Arrays.asList(getPropertyValues()).iterator();
    }

    @Override
    default Spliterator<PropertyValue> spliterator() {
        return Spliterators.spliterator(getPropertyValues(), 0);
    }

    default Stream<PropertyValue> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

}
