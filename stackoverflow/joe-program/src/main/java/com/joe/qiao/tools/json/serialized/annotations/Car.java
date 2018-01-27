package com.joe.qiao.tools.json.serialized.annotations;

/**
 * @author Joe Qiao
 * @Date 26/01/2018.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "ignoreCa", "ignoreVe" })
public class Car extends Vehicle {
    private int seatingCapacity;
    private double topSpeed;
    @JsonIgnore
    private String name="name";
    private String ignoreCa;

    public Car(String make, String model, int seatingCapacity, double topSpeed) {
        super(make, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }
    
    public Car(){

    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIgnoreCa() {
        return ignoreCa;
    }

    public void setIgnoreCa(String ignoreCa) {
        this.ignoreCa = ignoreCa;
    }
}
