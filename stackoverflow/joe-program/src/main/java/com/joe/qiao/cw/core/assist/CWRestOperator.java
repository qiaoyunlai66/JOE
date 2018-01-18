package com.joe.qiao.cw.core.assist;

/**
 * Created by Joe Qiao on 02/01/2018.
 */

public enum CWRestOperator{
    AND(" and "), OR(" or ");

    public String getValue() {
        return value;
    }

    private String value;
    CWRestOperator(String value) {
        this.value = value;
    }
    
}
