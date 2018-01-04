package com.joe.qiao.tools.http;

import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
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
import java.net.URL;
import java.util.List;

/**
 * Created by Joe Qiao on 2017/4/24.
 */
public class RestClient {

    protected String restHost = "";
    protected String user = "";
    protected String password = "";
    protected String domain = "";
    protected String restResultMessage = "";
    protected Integer restStatusCode = 0;
    protected String latestReq = "";
    protected String ticketJson = "";
    public final static int NO_WEB_SERVER=404;

    public void setRestHost(String value) {
        restHost = value;
    }

    public String getRestHost() {
        return restHost;
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

    public String getLatestReq() {
        return latestReq;
    }

    public void setLatestReq(String latestReq) {
        this.latestReq = latestReq;
    }

    public String getTicketJson() {
        return ticketJson;
    }

    public void setTicketJson(String ticketJson) {
        this.ticketJson = ticketJson;
    }

    public int executeRestMethod(String restAction) throws ParseException, IOException {
        this.latestReq = restAction;
        if (!restHost.toLowerCase().startsWith("http")) {
            restHost = "https://" + restHost;
        }
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        try {
            HttpGet httpGet = new HttpGet(restHost + restAction);
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

    public int executeRestGetFilterMethod(String restAction, List<NameValuePair> paramPairs) throws ParseException, IOException {
        this.latestReq = restAction;
        if (!restHost.toLowerCase().startsWith("http")) {
            restHost = "https://" + restHost;
        }
        URL url = new URL(restHost);
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
        this.latestReq = restAction;
        this.ticketJson = ticketJson;
        if (!restHost.toLowerCase().startsWith("http")) {
            restHost = "https://" + restHost;
        }
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        try {
            HttpPost httpPost = new HttpPost(restHost + restAction);
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
        this.latestReq=restAction;
        this.ticketJson=ticketJson;
        if (!restHost.toLowerCase().startsWith("http")) {
            restHost = "https://" + restHost;
        }
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        try {
            HttpPut httpPut = new HttpPut(restHost + restAction);
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

}
