package com.joe.qiao.cw.core;

import com.joe.qiao.tools.http.HttpBean;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 14/01/2018.
 */
public class CWRestHelper {
    public final static String SCHEME="https";
    public final static String HOST="staging.connectwisedev.com";
    public final static String BASE_URL ="/v4_6_release/apis/3.0";
    public final static String DOMAIN="fortinet_f";
    public final static String PUBLIC_KEY="8osRhQPXt6dI1ykl";
    public final static String PRIVATE_KEY="esjEnde9VTanEeo2";

    /**
     * 
     * @param path EX: /service/tickets
     * @return {@link CWBean}
     * @throws URISyntaxException
     */
    public static CWBean getCWBean(String path) throws URISyntaxException {
        CWBean cwBean= new CWBean();
        cwBean.setScheme(SCHEME);
        cwBean.setDomain(DOMAIN);
        cwBean.setHost(HOST);
        cwBean.setPath(BASE_URL +path);
        cwBean.setPublicKey(PUBLIC_KEY);
        cwBean.setPrivateKey(PRIVATE_KEY);
        return cwBean;
    }

    public static CWBean getCWBean(String path,RestParmeter restParmeter) throws URISyntaxException {
        CWBean cwBean= new CWBean();
        cwBean.setScheme(SCHEME);
        cwBean.setDomain(DOMAIN);
        cwBean.setHost(HOST);
        cwBean.setPath(BASE_URL +path);
        cwBean.setPublicKey(PUBLIC_KEY);
        cwBean.setPrivateKey(PRIVATE_KEY);
        cwBean.setRestParmeter(restParmeter);
        return cwBean;
    }
}
