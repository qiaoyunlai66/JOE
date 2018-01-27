package com.joe.qiao.tools.json.serialized.inheritance;

/**
 * @author Joe Qiao
 * @Date 26/01/2018.
 */
public abstract class Vehicle implements Top{
    private String make;
    private String model;

    protected Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }
     public Vehicle(){}

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
