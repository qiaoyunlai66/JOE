package com.joe.qiao.cw.execute;

import com.joe.qiao.cw.core.*;
import com.joe.qiao.cw.core.assist.CWRestOperator;
import com.joe.qiao.cw.core.assist.Method;
import com.joe.qiao.cw.core.assist.RestParmeter;
import org.apache.http.auth.AuthenticationException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 15/01/2018.
 */
public class HttpGen {
    
    public static void main(String[] args) {
        new HttpGen().get();
    }
    public void get(){
        try {
            CWBean cwBean = CWRestHelper.getCWBean("/company/configurations");
            RestParmeter restParmeter = new RestParmeter();
            restParmeter.addConditionsParm("board/name", "joe_test1", true, CWRestOperator.AND );
            cwBean.setRestParmeter(restParmeter);
            RestHttpExecute restHttpExecute = new RestHttpExecute(cwBean, Method.GET);
            restHttpExecute.execute();
            System.out.println("status="+restHttpExecute.getStatus()+"\n"+"result: "+restHttpExecute.getResult());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public void delete(){
        try {
            CWBean cwBean = CWRestHelper.getCWBean("/service/tickets/552");
           
            RestHttpExecute restHttpExecute = new RestHttpExecute(cwBean, Method.GET);
            restHttpExecute.execute();
            System.out.println("status="+restHttpExecute.getStatus()+"\n"+"result: "+restHttpExecute.getResult());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }  
    }
}
