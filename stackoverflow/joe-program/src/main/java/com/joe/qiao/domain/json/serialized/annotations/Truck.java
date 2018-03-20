package com.joe.qiao.domain.json.serialized.annotations;

/**
 * @author Joe Qiao
 * @Date 26/01/2018.
 */
public class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String make, String model, double payloadCapacity) {
        super(make, model);
        this.payloadCapacity = payloadCapacity;
    }

    public Truck() {
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
}
