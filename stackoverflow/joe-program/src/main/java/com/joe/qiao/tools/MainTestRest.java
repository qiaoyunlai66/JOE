package com.joe.qiao.tools;

import com.joe.qiao.cw.resttools.CWRestOperator;
import com.joe.qiao.cw.resttools.RestParmeter;
import com.joe.qiao.tools.http.RestClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Joe Qiao on 03/01/2018.
 */
public class MainTestRest {
    
    public static void main(String[] args) {
        //new MainTestRest().executeRestGetFilter();
      //  new MainTestRest().executeRestPut();
        try {
            String restUrl= URLEncoder.encode("id%20desc", "utf-8");
            System.out.println(restUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void executeRestPut(){
        
    }
    
    private void executeRestGetFilter() {
        RestParmeter restParmeter = new RestParmeter();
        restParmeter.addConditionsParm("ipAddress","10.30.30.143",true, CWRestOperator.AND);
        restParmeter.addConditionsParm("company/identifier","YourCompany",true,CWRestOperator.AND);
        RestClient restClient = new RestClient();
        restClient.setRestHost("http://staging.connectwisedev.com");
        restClient.setUser("8osRhQPXt6dI1ykl");
        restClient.setDomain("fortinet_f");
        restClient.setPassword("esjEnde9VTanEeo2");
        try {
            restClient.executeRestGetFilterMethod("/v4_6_release/apis/3.0/company/configurations",restParmeter.buildParams());
            System.out.println("result message :"+restClient.getRestResultMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
