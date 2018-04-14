package com.webage.client;

import ejb.ejb32.war.SimpleBean;

import javax.naming.InitialContext;

/**
 * @author Joe Qiao
 * @Date 08/04/2018.
 */
public class TestClient {
    public void runTest() throws Exception {
        InitialContext ctx = new InitialContext();
        SimpleBean bean = (SimpleBean) ctx.lookup("ejb/SimpleBeanJNDI");
        String result = bean.sayHello("Billy Bob");
        System.out.println(result);
    }

    public static void main(String[] args) {
        try {
            TestClient cli = new TestClient();
            cli.runTest();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
