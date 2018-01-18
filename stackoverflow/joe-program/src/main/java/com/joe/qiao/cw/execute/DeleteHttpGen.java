package com.joe.qiao.cw.execute;

import com.joe.qiao.cw.core.CWBean;
import com.joe.qiao.cw.core.CWRestClient;
import com.joe.qiao.cw.core.CWRestHelper;
import com.joe.qiao.cw.core.RestHttpGen;
import org.apache.http.auth.AuthenticationException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 15/01/2018.
 */
public class DeleteHttpGen extends RestHttpGen {
    
    public DeleteHttpGen(CWBean cwBean){
        this.cwBean = cwBean;
    }
    
    public DeleteHttpGen(){}
    
    public int execute(String path) throws URISyntaxException, IOException, AuthenticationException {
        cwBean = CWRestHelper.getCWBean(path);
        CWRestClient client=new CWRestClient(this);
        int status = client.executeDeleteMethod();
        result = client.getResultMessage();
        return status;
    }
}
