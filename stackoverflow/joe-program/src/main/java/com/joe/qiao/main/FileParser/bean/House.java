package com.joe.qiao.main.FileParser.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Joe Qiao
 * @Date 06/02/2018.
 */
public class House implements Serializable{
    public static final long serialVersionUID = 42L;

    private Date date = new Date(); //记录当前的时间

    public String toString() {
        return "House:" + super.toString() + ".Create Time is:" + date;
    }
}
