package com.muyi.summer.tinyspring.core.io.resource;

import java.io.File;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: muyi
 * Date: 2018/3/30
 * Description:
 *
 * Interface for a resource descriptor that abstracts from the actual type of underlying resource,such as a file or class path resource.
 *
 * An InputStream can be opened for every resource if it exists in physical form,
 * but a URL or File handle can just be returned for certain resources.
 * The actual behavior is implementation-specific
 *
 * 这里定义一个resource 所有可以做的事情，仅列出重要的几个
 */
public interface Resource extends InputStreamSource {

    //根据相对路径创建一个新的resource
    Resource createRelative(String relativePath);

    //判断本资源是否实际存在在物理系统中
    boolean exists();

    //拿到file handle
    File getFile();

    //拿到url handle
    URL getURL();

    //拿到filename  i.e. typically the last part of the path: for example, "myfile.txt".
    String getFileName();

}
