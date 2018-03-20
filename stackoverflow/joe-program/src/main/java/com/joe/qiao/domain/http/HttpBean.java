package com.joe.qiao.domain.http;

import java.net.URI;

/**
 * @author Joe Qiao
 * @Date 14/01/2018.
 */
public class HttpBean {
    protected String user;
    protected String password;
    protected URI uri;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
