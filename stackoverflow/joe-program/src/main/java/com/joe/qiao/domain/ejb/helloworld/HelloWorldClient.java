package com.joe.qiao.domain.ejb.helloworld;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * @author Joe Qiao
 * @Date 24/03/2018.
 */
public class HelloWorldClient {
    public static  void main(String[] args){
//        Properties props = new Properties();
//
//        props.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
//
//        props.setProperty("java.naming.provider.url","localhost:1099");
        
        try {
            InitialContext context =new InitialContext();
            HelloWorldEJB helloWorldEJB=(HelloWorldEJB) context.lookup("HelloWorldBean/remote");
            String s=helloWorldEJB.sayHello("helloworld");
            System.out.print(s);
        } catch (NamingException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }

    }
}
