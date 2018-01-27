package com.joe.qiao.tools.json.serialized.annotations;

/**
 * @author Joe Qiao
 * @Date 27/01/2018.
 */
public class Bike extends Vehicle{
    String name;
    String color;
    String value;

    public Bike() {
    }

    public Bike(String name, String color, String value) {
        this.name = name;
        this.color = color;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
