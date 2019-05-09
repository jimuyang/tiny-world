package com.muyi.summer.tinyspring.core.io.resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: muyi
 * Date: 2018/3/30
 * Description:
 *      Simple interface for objects that are sources for an InputStream.
 *      这种类型的资源可以拿到他的输入流
 */
public interface InputStreamSource {

    /**
     * Return an InputStream.
     *
     * It is expected that each call creates a fresh stream.
     * This requirement is particularly important when you consider an API such as JavaMail,
     * which needs to be able to read the stream multiple times when creating mail attachments.
     * For such a use case, it is required that each getInputStream() call returns a fresh stream.
     */
    InputStream getInputSteam() throws IOException;
}
