package com.joe.qiao.domain.json.serialized.annotations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Joe Qiao
 * @Date 27/01/2018.
 */
public class NoargConstructor extends Vehicle{
    private String name;
    private String color;
    @JsonCreator
    public NoargConstructor(
            @JsonProperty("name") String name,
            @JsonProperty("color") String color) {
       this.name = name;
       this.color= color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
