package com.joe.qiao.domain.ejb.helloworld;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author Joe Qiao
 * @Date 24/03/2018.
 */

@Stateless
@Remote
public class HelloWorldBean implements HelloWorldEJB{
    @Override
    public String sayHello(String str) {
        return str;
    }
}
