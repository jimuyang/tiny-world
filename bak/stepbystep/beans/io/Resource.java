package com.muyi.summer.stepbystep.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:15 2018/1/31
 * @Description: Resource是spring内部定位资源的接口
 */
public interface Resource {
    InputStream getInputStream()  throws IOException;
}
