package com.muyi.summer.stepbystep.beans.io;

import java.net.URL;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:20 2018/1/31
 * @Description:
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        System.out.println(resource.getPath());
        return new UrlResource(resource);
    }

}

