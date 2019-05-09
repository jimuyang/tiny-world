package com.muyi.summer.stepbystep.beans;

import com.muyi.summer.stepbystep.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:13 2018/1/31
 * @Description:
 *
 * 实现 BeanDefinitionReader 接口的抽象类（未具体实现 loadBeanDefinitions，而是规范了 BeanDefinitionReader 的基本结构）。
 * 内置一个 HashMap rigistry，用于保存 String - beanDefinition 的键值对。
 * 内置一个 ResourceLoader resourceLoader，用于保存类加载器。
 * 用意在于，使用时，只需要向其 loadBeanDefinitions() 传入一个资源地址，就可以自动调用其类加载器，并把解析到的 BeanDefinition 保存到 registry 中去。
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
