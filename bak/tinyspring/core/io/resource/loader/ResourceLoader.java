package com.muyi.summer.tinyspring.core.io.resource.loader;

import com.muyi.summer.tinyspring.core.io.resource.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: muyi
 * Date: 2018/3/30
 * Description: 加载resource的loader
 */
public interface ResourceLoader {

    /**
     * @param location the resource location
     * @return Resource handle for the specified resource location.
     */
    Resource getResource(String location);

    ClassLoader getClassLoader();

}
