package com.joe.qiao.main.datastructure;

import com.joe.qiao.drreports.global.TOCLevel;

/**
 * @author Joe Qiao
 * @Date 24/01/2018.
 */
public class BasicGrammerTest {
    public static void main(String[] args) {
        new BasicGrammerTest().testSwitch();
    }
    public void testSwitch(){
        TOCLevel tocLevel = TOCLevel.FIRST;
        switch (tocLevel){
            case FIRST:
                System.out.println("f");
            case SECOND:
                System.out.println("s");
                break;
            default:System.out.println("n");
        }
    }
}
