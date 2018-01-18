package com.joe.qiao.cw.core;

import com.joe.qiao.tools.http.HttpBean;
import com.joe.qiao.tools.http.JQHttpClient;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 15/01/2018.
 */
public class RestHttpGen implements HttpGen {
    protected CWBean cwBean;
    protected String result;
    
    @Override
    public JQHttpClient getJQHttpClient() {
        HttpBean httpBean = null;
        try {
            URIBuilder uriBuilder = new URIBuilder();
            RestParmeter restParmeter = cwBean.getRestParmeter();
            uriBuilder.setScheme(cwBean.getScheme());
            uriBuilder.setHost(cwBean.getHost());
            uriBuilder.setPath(cwBean.getPath());
            if(restParmeter!=null){
                uriBuilder.setParameters(restParmeter.buildParams());
            }
            httpBean=new HttpBean();
            httpBean.setUri(uriBuilder.build());
            httpBean.setUser(cwBean.getDomain()+"+"+cwBean.getPublicKey());
            httpBean.setPassword(cwBean.getPrivateKey());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new JQHttpClient(httpBean);
    }
    
}
