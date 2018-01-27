package com.joe.qiao.tools.json.serialized.annotations;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Joe Qiao
 * @Date 27/01/2018.
 */
public class BikeMixin {
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
