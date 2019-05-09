package com.muyi.summer.tinyspring.core.io.resource.loader;

import com.muyi.summer.tinyspring.core.io.resource.Resource;
import com.muyi.summer.tinyspring.core.io.resource.UrlResource;
import org.springframework.core.io.DefaultResourceLoader;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: muyi
 * Date: 2018/3/30
 * Description:
 */
public class UrlResourceLoader implements ResourceLoader {

    private DefaultResourceLoader resourceLoader;


    @Override
    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        // System.out.println(resource.getPath());
        return new UrlResource(url);
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }
}
