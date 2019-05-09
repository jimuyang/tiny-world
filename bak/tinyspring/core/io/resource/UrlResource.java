package com.muyi.summer.tinyspring.core.io.resource;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * Created with IntelliJ IDEA.
 * User: muyi
 * Date: 2018/3/30
 * Description:
 */
public class UrlResource implements Resource {

    //spring UrlResource
    private org.springframework.core.io.UrlResource urlResource;

    @Nullable
    private final URI uri;
    private final URL url;
    private final URL cleanedUrl;

    public UrlResource(URI uri) throws MalformedURLException {
        Assert.notNull(uri, "URI must not be null");
        this.uri = uri;
        this.url = uri.toURL();
        this.cleanedUrl = this.getCleanedUrl(this.url, uri.toString());
    }

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
        this.cleanedUrl = this.getCleanedUrl(this.url, url.toString());
        this.uri = null;
    }

    public UrlResource(String path) throws MalformedURLException {
        Assert.notNull(path, "Path must not be null");
        this.uri = null;
        this.url = new URL(path);
        this.cleanedUrl = this.getCleanedUrl(this.url, path);
    }
    private URL getCleanedUrl(URL originalUrl, String originalPath) {
        try {
            return new URL(StringUtils.cleanPath(originalPath));
        } catch (MalformedURLException var4) {
            return originalUrl;
        }
    }



    @Override
    public Resource createRelative(String relativePath) {
        return null;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public URL getURL() {
        return null;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public InputStream getInputSteam() throws IOException {
        URLConnection con = this.url.openConnection();

        //Set the "useCaches" flag on the given connection,
        //preferring false but leaving the flag at true for JNLP based resources.
        ResourceUtils.useCachesIfNecessary(con);

        try {
            return con.getInputStream();
        } catch (IOException var3) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection)con).disconnect();
            }

            throw var3;
        }
    }
}
