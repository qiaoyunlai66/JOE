package com.joe.qiao.cw.core;

import com.joe.qiao.cw.core.assist.RestParmeter;

/**
 * @author Joe Qiao
 * @Date 14/01/2018.
 */
public class CWBean{
    private String scheme;
    private String host;
    private String path;
    private String domain;
    private String publicKey;
    private String privateKey;
    private RestParmeter restParmeter;

    public CWBean(){}

    public CWBean(String scheme, String host, String path, String domain, String publicKey, String privateKey, RestParmeter restParmeter) {
        this.scheme = scheme;
        this.host = host;
        this.path = path;
        this.domain = domain;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.restParmeter = restParmeter;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public RestParmeter getRestParmeter() {
        return restParmeter;
    }

    public void setRestParmeter(RestParmeter restParmeter) {
        this.restParmeter = restParmeter;
    }
}
