package muyi.tiny.spring.util;

import org.springframework.util.ClassUtils;

import java.util.*;

/**
 * @author: Yang Fan
 * @date: 2019-05-15
 * @desc:
 */
public class ClassUtil {

    /**
     * 包装类型和基本类型映射
     * Integer.class -> int.class
     * IdentityHashMap: key比较要求 key1 == key2
     */
    private static final Map<Class<?>, Class<?>> WRAPPER_TYPE_TO_PRIMITIVE = new IdentityHashMap<>(8);

    /**
     * int.class -> Integer.class
     */
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TYPE_TO_WRAPPER = new IdentityHashMap<>(8);

    /**
     * 基本类型name映射类型
     * "int" -> int.class
     */
    private static final Map<String, Class<?>> PRIMITIVE_NAME_TO_TYPE = new HashMap<>(32);

    static {
        WRAPPER_TYPE_TO_PRIMITIVE.put(Boolean.class, boolean.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Byte.class, byte.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Character.class, char.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Double.class, double.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Float.class, float.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Integer.class, int.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Long.class, long.class);
        WRAPPER_TYPE_TO_PRIMITIVE.put(Short.class, short.class);

        WRAPPER_TYPE_TO_PRIMITIVE.forEach((wrapper, primitive) -> PRIMITIVE_TYPE_TO_WRAPPER.put(primitive, wrapper));

        Set<Class<?>> primitiveTypes = new HashSet<>(32);
        primitiveTypes.addAll(WRAPPER_TYPE_TO_PRIMITIVE.values());
        Collections.addAll(primitiveTypes, boolean[].class, byte[].class, char[].class,
                double[].class, float[].class, int[].class, long[].class, short[].class);
        primitiveTypes.add(void.class);
        primitiveTypes.forEach(primitiveType -> PRIMITIVE_NAME_TO_TYPE.put(primitiveType.getName(), primitiveType));

    }

    /**
     * 替代Class.forName()
     */
    public static Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException {
        //......
        return ClassUtils.forName(name, classLoader);
    }

    public static Class<?> resolvePrimitiveClassName(String name) {
        Class<?> result = null;
        // Most class names will be quite long, considering that they
        // SHOULD sit in a package, so a length check is worthwhile.
        if (name != null && name.length() <= 8) {
            // Could be a primitive - likely.
            result = PRIMITIVE_NAME_TO_TYPE.get(name);
        }
        return result;
    }

}
