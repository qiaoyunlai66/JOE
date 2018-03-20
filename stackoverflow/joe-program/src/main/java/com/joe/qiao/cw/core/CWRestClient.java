package com.joe.qiao.cw.core;

import com.joe.qiao.cw.core.assist.RestParmeter;
import com.joe.qiao.domain.http.HttpBean;
import com.joe.qiao.domain.http.HttpClientUtil;
import com.joe.qiao.domain.http.JQHttpClient;
import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * @author Joe Qiao
 * @Date 12/01/2018.
 */
public class CWRestClient {
    private JQHttpClient jqHttpClient;
    private CWBean cwBean;
    protected String user = "";
    protected String password = "";
    protected String domain = "";
    protected String restResultMessage = "";
    protected Integer restStatusCode = 0;
    protected String ticketJson = "";
    public final static int NO_WEB_SERVER=404;
    final static String NO_CLIENT="No JQHTTPCLient Found";
    
    public CWRestClient(CWBean cwBean){
        this.cwBean=cwBean;
        init();
    }
    
    public void setUser(String value) {
        user = value;
    }

    public String getUser() {
        return user;
    }

    public void setPassword(String value) {
        password = value;
    }

    public String getPassword() {
        return password;
    }

    public Integer getRestStatusCode() {
        return restStatusCode;
    }

    public String getRestResultMessage() {
        return restResultMessage;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setRestStatusCode(Integer restStatusCode) {
        this.restStatusCode = restStatusCode;
    }

    public void setRestResultMessage(String restResultMessage) {
        this.restResultMessage = restResultMessage;
    }

    public String getTicketJson() {
        return ticketJson;
    }

    public void setTicketJson(String ticketJson) {
        this.ticketJson = ticketJson;
    }

    public int executeGetMethod() throws IOException, URISyntaxException, AuthenticationException {
        if(jqHttpClient==null) {
            throw new RuntimeException(NO_CLIENT);
        }
        return jqHttpClient.executeGetMethod();
    }
    
    public int executeDeleteMethod() throws IOException,URISyntaxException, AuthenticationException{
        if(jqHttpClient==null){
            throw new RuntimeException(NO_CLIENT);
        }
        return jqHttpClient.executeDeleteMethod();
    }

    public int executeRestGetFilterMethod(String restAction, List<NameValuePair> paramPairs) throws ParseException, IOException {
        URL url = new URL("");
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        try {
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme(url.getProtocol()).setHost(url.getHost()).setPath(restAction);
            uriBuilder.setParameters(paramPairs);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader(getAuthenticate());
            HttpResponse httpResponse = httpClient.execute(httpGet);
            restStatusCode = httpResponse.getStatusLine().getStatusCode();
            HttpEntity httpEntity = httpResponse.getEntity();
            restResultMessage = EntityUtils.toString(httpEntity);
            return restStatusCode;
        } catch(Exception e){
            restResultMessage = e.toString();
            return NO_WEB_SERVER;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public int executeRestPostMethod(String restAction, String ticketJson) throws Exception {
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        try {
            HttpPost httpPost = new HttpPost("" + restAction);
            httpPost.addHeader(getAuthenticate());
            StringEntity entity = new StringEntity(ticketJson);
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            restStatusCode = httpResponse.getStatusLine().getStatusCode();
            HttpEntity httpEntity = httpResponse.getEntity();
            restResultMessage = EntityUtils.toString(httpEntity);
            return restStatusCode;
        } catch(Exception e){
            restResultMessage = e.toString();
            return NO_WEB_SERVER;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public int executeRestPutMethod(String restAction, String ticketJson) throws Exception{
        this.ticketJson=ticketJson;
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        try {
            HttpPut httpPut = new HttpPut("" + restAction);
            httpPut.addHeader(getAuthenticate());
            StringEntity entity = new StringEntity(ticketJson);
            entity.setContentType("application/json");
            httpPut.setEntity(entity);
            HttpResponse httpResponse = httpClient.execute(httpPut);
            restStatusCode = httpResponse.getStatusLine().getStatusCode();
            HttpEntity httpEntity = httpResponse.getEntity();
            restResultMessage = EntityUtils.toString(httpEntity);
            return restStatusCode;
        } catch(Exception e){
            restResultMessage = e.toString();
            return NO_WEB_SERVER;
        }finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public Header getAuthenticate() {
        if (StringUtils.isEmpty(domain)) {
            domain = "training";
        }
        return BasicScheme.authenticate(new UsernamePasswordCredentials(domain + "+" + user, password), "UTF-8", false);
    }

    public static void main(String[] args) {
    }

    public String getResultMessage() {
        if(jqHttpClient!=null){
            return jqHttpClient.getResultMessage();
        }
        return null;
    }

    public void init() {
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
        if(jqHttpClient==null){
            jqHttpClient = new JQHttpClient(httpBean);
        }
    }
    
}
