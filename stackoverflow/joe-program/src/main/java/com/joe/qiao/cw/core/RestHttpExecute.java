package com.joe.qiao.cw.core;

import com.joe.qiao.cw.core.assist.Method;
import org.apache.http.auth.AuthenticationException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 15/01/2018.
 */
public class RestHttpExecute implements Execute {
    protected CWBean cwBean;
    protected Method method;
    private int status;
    private String result;
    CWRestClient client;

    public RestHttpExecute(CWBean cwBean, Method method) {
        this.cwBean = cwBean;
        this.method = method;
    }

    @Override
    public void execute(){
        if(method==null){
            System.out.println("Error : please set Http method..");
        }else if(method==Method.GET){
            if(client==null){
                client = new CWRestClient(cwBean);
            }
            try {
                status = client.executeGetMethod();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }else if(method==Method.DELETE){
            if(client==null){
                client = new CWRestClient(cwBean);
            }
            try {
               status = client.executeDeleteMethod();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
    }

    public int getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }
}
