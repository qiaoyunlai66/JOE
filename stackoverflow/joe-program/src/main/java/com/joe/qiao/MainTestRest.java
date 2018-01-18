package com.joe.qiao;

import com.joe.qiao.cw.core.assist.CWRestOperator;
import com.joe.qiao.cw.core.assist.RestParmeter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Joe Qiao on 03/01/2018.
 */
public class MainTestRest {
    
    public static void main(String[] args) {
        //new MainTestRest().executeRestGetFilter();

        try {
            new MainTestRest().testUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            String restUrl= URLEncoder.encode("id%20desc", "utf-8");
//            System.out.println(restUrl);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }

   private void testUrl() throws MalformedURLException {
       URL url =new URL("https:/172.30.57.27/phoenix/genCMDBReport?key=report--1491929312157.pdf");
       System.out.println(url.getQuery());
   } 
    
    private void executeRestPut() throws Exception {
  //      JQHttpClient restClient = new JQHttpClient();
//        restClient.setRestHost("https://staging.connectwisedev.com");
//        restClient.setUser("8osRhQPXt6dI1ykl");
//        restClient.setDomain("fortinet_f");
//        restClient.setPassword("esjEnde9VTanEeo2");
//        restClient.executeRestPutMethod("/v4_6_release/apis/3.0/company/configurations/71", FileParser.readFile(new File("/Users/qiaoyunlai/opt/phoenix/project-joe/JOE/stackoverflow/joe-program/src/main/resources/com/joe/qiao/json/configurationPut.json")));
    }
    
    private void executeRestGetFilter() {
        RestParmeter restParmeter = new RestParmeter();
        restParmeter.addConditionsParm("ipAddress","10.30.30.143",true, CWRestOperator.AND);
        restParmeter.addConditionsParm("company/identifier","YourCompany",true,CWRestOperator.AND);
//        JQHttpClient restClient = new JQHttpClient();
//        restClient.setRestHost("http://staging.connectwisedev.com");
//        restClient.setUser("8osRhQPXt6dI1ykl");
//        restClient.setDomain("fortinet_f");
//        restClient.setPassword("esjEnde9VTanEeo2");
//        try {
//            restClient.executeRestGetFilterMethod("/v4_6_release/apis/3.0/company/configurations",restParmeter.buildParams());
//            System.out.println("result message :"+restClient.getResultMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
