package com.joe.qiao.cw.resttools;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe Qiao on 03/01/2018.
 */
public class RestParmeter {
    private List<NameValuePair> parms;
    private String condition;
    public final static String CONDITIONS = "conditions";
    
    public void addParm(String key, String value){
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key,value);
        if(parms == null){
            parms = new ArrayList<>();
        }
        parms.add(basicNameValuePair);
    }
    
    public void addConditionsParm(String key,String value,boolean isTextValue,CWRestOperator operator){
        if(parms == null){
            parms = new ArrayList<>();
        }
        if(isTextValue){
            value = "'"+value+"'";
        }
        if(operator ==null){
            operator = CWRestOperator.AND;
        }
        if(condition == null){
            condition = key + "=" +value;
        }else{
            condition = condition + operator.getValue()+key +"="+value;
        }
    }
    
    public List<NameValuePair> buildParams(){
        BasicNameValuePair basicNameValuePair = null;
        if(condition!=null){
            basicNameValuePair =new BasicNameValuePair(CONDITIONS,condition);
        }
        if(parms == null){
            parms = new ArrayList<>();
        }
        if(basicNameValuePair!=null) {
            parms.add(basicNameValuePair);
        }
        return parms;
    }
}
