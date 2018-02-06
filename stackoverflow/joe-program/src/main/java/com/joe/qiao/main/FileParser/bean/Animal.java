package com.joe.qiao.main.FileParser.bean;

import java.io.Serializable;

/**
 * @author Joe Qiao
 * @Date 06/02/2018.
 */
public class Animal implements Serializable{
    public static final long serialVersionUID = 42L;
    private String name;

    private transient String noneed;
    
    private House house;

    public Animal(String name , House house) {
        this.name = name;
        this.house = house;
        System.out.println("调用了构造器");
    }

    public String toString() {
        return  name + "[" +super.toString() + "']" + house;
    }
}
