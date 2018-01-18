package com.joe.qiao.cw.execute;

import com.joe.qiao.cw.core.assist.CWRestOperator;
import com.joe.qiao.cw.core.assist.RestParmeter;
import com.joe.qiao.cw.devbean.Configuration;
import com.joe.qiao.tools.json.JSONHelper;
import org.apache.http.auth.AuthenticationException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Joe Qiao
 * @Date 16/01/2018.
 */
public class MainFunction {

    public static void main(String[] args) {
        MainFunction mainFunction = new MainFunction();
      //  mainFunction.removeAll("/service/tickets","board/name","joe_test1",true,CWRestOperator.AND);
    }
    
//    public int removeAll(String path, String key, String value, boolean isTextValue, CWRestOperator operator){
//       try {
//           RestParmeter restParmeter = new RestParmeter();
//           restParmeter.addConditionsParm(key, value, isTextValue, operator);
//           HttpGen getHttpGen = new HttpGen();
//        //   int status = getHttpGen.execute(path,restParmeter);
//      //     List<Configuration> configurations = JSONHelper.fromJsonForObjList(getHttpGen.getResult(),Configuration.class);
//           int total =1;
////           for(Configuration c:configurations){
////               int deleteId=c.getId();
////               DeleteHttpGen deleteHttpGen = new DeleteHttpGen();
////           //    deleteHttpGen.execute("/service/tickets"+"/"+deleteId);
////               System.out.println(deleteId+"  " + "toal = "+ total);
////               total++;
////           }
////       } catch (IOException e) {
////           e.printStackTrace();
////       } catch (URISyntaxException e) {
////           e.printStackTrace();
////       } catch (AuthenticationException e) {
////           e.printStackTrace();
////       } catch (Exception e) {
////           e.printStackTrace();
////       }
//       return 1;
//    }
}
