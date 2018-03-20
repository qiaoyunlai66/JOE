/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.qiao.domain.http;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


/**
 *
 * @author Joe Qiao
 */
public class HttpClientUtil {

    public static CloseableHttpClient getHttpClient(String username, String password) {

        CloseableHttpClient httpClient;
        
        String proxyHost = System.getProperty("https.proxyHost");
        String proxyPort = "";
        String proxyUser = "";
        String proxyPassword = "";
        Boolean hasProxy = false;

        if (StringUtils.isNotBlank(proxyHost)) {
            proxyPort = System.getProperty("https.proxyPort");
            if (StringUtils.isBlank(proxyPort)) {
                proxyPort = "443";
            }
            hasProxy = true;
            proxyUser = System.getProperty("https.proxyUser");
            proxyPassword = System.getProperty("https.proxyPassword");
        } else {
            proxyHost = System.getProperty("http.proxyHost");
            if (StringUtils.isNotBlank(proxyHost)) {
                proxyPort = System.getProperty("http.proxyPort");
                if (StringUtils.isBlank(proxyPort)) {
                    proxyPort = "80";
                }
                hasProxy = true;
                proxyUser = System.getProperty("http.proxyUser");
                proxyPassword = System.getProperty("http.proxyPassword");
            }
        }

        System.out.println("ProxyHost =" + (proxyHost != null ? proxyHost : ""));
        
        // Create an Apache HttpClientBuilder.
        HttpClientBuilder cb = HttpClientBuilder.create();
       
        
        RequestConfig config;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        if (hasProxy) {
//            HttpHost proxy = new HttpHost(proxyHost, Integer.valueOf(proxyPort));
//            config = RequestConfig.custom().setProxy(proxy).build();
//            if (StringUtils.isNotBlank(proxyUser)) {
//                credsProvider.setCredentials(
//                        new AuthScope(proxyHost, Integer.valueOf(proxyPort)),
//                        new UsernamePasswordCredentials(proxyUser, proxyPassword));
//            }
//        } else {
            config = RequestConfig.DEFAULT;
     //   }
        cb.setDefaultRequestConfig(config);
        
        
        if (StringUtils.isNotBlank(username)) {
            
            credsProvider.setCredentials(
                    AuthScope.ANY,
                    new UsernamePasswordCredentials(username, password));
           
        }
        cb.setDefaultCredentialsProvider(credsProvider);
        
        httpClient = cb.build();


        return httpClient;
    }
    
    public static CloseableHttpClient getHttpClient() {

        CloseableHttpClient httpClient;
        
        String proxyHost = System.getProperty("https.proxyHost");
        String proxyPort = "";
        String proxyUser = "";
        String proxyPassword = "";
        Boolean hasProxy = false;

        if (StringUtils.isNotBlank(proxyHost)) {
            proxyPort = System.getProperty("https.proxyPort");
            if (StringUtils.isBlank(proxyPort)) {
                proxyPort = "443";
            }
            hasProxy = true;
            proxyUser = System.getProperty("https.proxyUser");
            proxyPassword = System.getProperty("https.proxyPassword");
        } else {
            proxyHost = System.getProperty("http.proxyHost");
            if (StringUtils.isNotBlank(proxyHost)) {
                proxyPort = System.getProperty("http.proxyPort");
                if (StringUtils.isBlank(proxyPort)) {
                    proxyPort = "80";
                }
                hasProxy = true;
                proxyUser = System.getProperty("http.proxyUser");
                proxyPassword = System.getProperty("http.proxyPassword");
            }
        }
        
        // Create an Apache HttpClientBuilder.
        HttpClientBuilder cb = HttpClientBuilder.create();
        
        RequestConfig config;
        
        if (hasProxy) {
            System.out.println("There is a Proxy Server defined in the System: ProxyHost =" + proxyHost);
            HttpHost proxy = new HttpHost(proxyHost, Integer.valueOf(proxyPort));
            config = RequestConfig.custom().setProxy(proxy).build();
            if (StringUtils.isNotBlank(proxyUser)) {
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(
                        new AuthScope(proxyHost, Integer.valueOf(proxyPort)),
                        new UsernamePasswordCredentials(proxyUser, proxyPassword));
                cb.setDefaultCredentialsProvider(credsProvider);
            }
        } else {
            config = RequestConfig.DEFAULT;
        }
        cb.setDefaultRequestConfig(config);

        httpClient = cb.build();
        
        return httpClient;
    }
}
