package com.joe.qiao.tools.http;

import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.*;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Joe Qiao on 2017/4/24.
 */
public class JQHttpClient {
    private HttpBean httpBean;
    private CloseableHttpClient httpClient;
    protected String resultMessage;

    public HttpBean getHttpBean() {
        return httpBean;
    }

    public void setHttpBean(HttpBean httpBean) {
        this.httpBean = httpBean;
    }

    public JQHttpClient(HttpBean httpBean){
        this.httpBean = httpBean;
    }
    public int executeGetMethod() throws IOException {
        if(!initHttpClient()){
            return HttpStatus.SC_BAD_REQUEST;
        }
        try {
            HttpGet httpGet = new HttpGet(httpBean.uri);
           return execute(httpGet);
        } catch(Exception e){
            resultMessage = e.toString();
            throw e;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public int executeDeleteMethod() throws IOException {
        if(!initHttpClient()){
            return HttpStatus.SC_BAD_REQUEST;
        }
        try {
            HttpDelete httpDelete = new HttpDelete(httpBean.uri);
            return execute(httpDelete);
        } catch(Exception e){
            resultMessage = e.toString();
            throw e;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public int executePostMethod(HttpEntity httpEntity) throws Exception {
        if(!initHttpClient()){
            return HttpStatus.SC_BAD_REQUEST;
        }        
        try {
            HttpPost httpPost = new HttpPost(httpBean.uri);
            if(httpEntity!=null)httpPost.setEntity(httpEntity);
            return execute(httpPost);
        } catch(Exception e){
            resultMessage = e.toString();
            throw e;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public int executePutMethod(HttpEntity httpEntity) throws Exception{
        if(!initHttpClient()){
            return HttpStatus.SC_BAD_REQUEST;
        }
        try {
            HttpPut httpPut = new HttpPut(httpBean.uri);
            if(httpEntity!=null)httpPut.setEntity(httpEntity);
            return execute(httpPut);
        } catch(Exception e){
            resultMessage = e.toString();
            throw e;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    /**
     * @deprecated should not put Anthen to header
     * @return
     */
//    public Header getAuthenticate() {
//        if (StringUtils.isEmpty(domain)) {
//            domain = "training";
//        }
//        return BasicScheme.authenticate(new UsernamePasswordCredentials(domain + "+" + user, password), "UTF-8", false);
//    }

    private int execute(HttpRequestBase httpRequestBase) throws IOException {
        HttpResponse httpResponse = httpClient.execute(httpRequestBase);
        HttpEntity httpEntity = httpResponse.getEntity();
        resultMessage = EntityUtils.toString(httpEntity);
        return httpResponse.getStatusLine().getStatusCode();
    }
    
    private boolean initHttpClient(){
        if(httpBean==null||httpBean.getUri()==null){
            return false;
        }
        if(httpClient!=null)httpClient = HttpClientUtil.getHttpClient(httpBean.getUser(),httpBean.getPassword());
        return true;
    }
}
