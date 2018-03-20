package com.joe.qiao.main.enumbasic;

import com.joe.qiao.domain.json.JSONHelper;

/**
 * @author Joe Qiao
 * @Date 28/02/2018.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Chart bar = Chart.BAR;
            bar.setI(2);
            System.out.println(JSONHelper.toJsonJackSon(Chart.BAR));
            Chart c = JSONHelper.fromJsonJackSon("\"PIE\"",Chart.class);
            System.out.println("dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
