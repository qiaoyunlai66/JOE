package com.joe.qiao.cw.execute;

import com.joe.qiao.cw.core.*;
import org.apache.http.auth.AuthenticationException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 15/01/2018.
 */
public class GetHttpGen extends RestHttpGen {
    
    public GetHttpGen(CWBean cwBean){
        this.cwBean = cwBean;
    }

    public GetHttpGen(){}
    
    public int execute(String path) throws URISyntaxException, IOException, AuthenticationException {
        cwBean = CWRestHelper.getCWBean(path);
        return execute();
    }
    
    public int execute(String path, RestParmeter restParmeter) throws URISyntaxException, IOException, AuthenticationException{
        cwBean = CWRestHelper.getCWBean(path,restParmeter);
        return execute();
    }
    
    public int execute() throws AuthenticationException, IOException, URISyntaxException {
        CWRestClient client=new CWRestClient(this);
        int status = client.executeGetMethod();
        result = client.getResultMessage();
        return status;
    }
    
    public String getResult(){
        return result;
    }
    
    public static void main(String[] args) {
        try {
            GetHttpGen getHttpGen = new GetHttpGen();
            int status = getHttpGen.execute("/company/configurations");
            System.out.println("status: "+status+"\nresult: "+getHttpGen.result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
