package com.joe.qiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joe Qiao
 * @Date 22/01/2018.
 */
public class MainTestCollection {
    public static void main(String[] args) {
        new MainTestCollection().test();
    }
    public void test(){
        String a = null;
        String b = "b";
        List<String> list = new ArrayList();
        list.add(a);
        list.add(b);
        for(String s:list){
            System.out.println(s);
        }
    }
}
