package muyi.tiny.spring.core;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author: Yang Fan
 * @date: 2019-05-16
 * @desc: 一些Type栗子
 * List<ArrayList> a1;//返回ArrayList，Class类型
 * List<ArrayList<String>> a2;//返回ArrayList<String>，ParameterizedType类型
 * List<T> a3;//返回T，TypeVariable类型
 * List<? extends Number> a4; //返回? extends Number，WildcardType类型
 * List<ArrayList<String>[]> a5;//返回ArrayList<String>[]，GenericArrayType 类型
 */
public class ResolvableType implements Serializable {

    // 简单做 支持Class先
    private final Type type;

    private final Integer hash;

    private Class<?> resolved;

    private volatile ResolvableType superType;

    private volatile ResolvableType[] interfaces;

    private volatile ResolvableType[] generics;

    public ResolvableType(Type type, Integer hash) {
        this.type = type;
        this.hash = hash;
        this.resolved = resolveClass();
    }

    public Class<?> getResolved() {
        return resolved;
    }

    public Class<?> getResolved(Class<?> fallback) {
        return resolved == null ? fallback : resolved;
    }

    //    public ResolvableType resolveType() {
//        // ParameterizedType代表的是一个泛型的实例
//        if (this.type instanceof ParameterizedType) {
//
//        }
//
//    }
//
    private Class<?> resolveClass() {
        if (this.type == EmptyType.INSTANCE) {
            return null;
        }

        if (this.type instanceof Class) {
            return (Class<?>) this.type;
        }

        if (this.type instanceof GenericArrayType) {
            // String[] 暂不支持
        }
        throw new RuntimeException("unsupported type: " + type.getTypeName());
//        return
    }

    public static class EmptyType implements Type, Serializable {
        static final Type INSTANCE = new EmptyType();
    }
}
