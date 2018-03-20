package com.joe.qiao.domain.json.serialized.annotations;

import java.util.List;

/**
 * @author Joe Qiao
 * @Date 26/01/2018.
 */
public class Fleet {
    private List<Vehicle> vehicles;
    private List<Top> top;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Top> getTop() {
        return top;
    }

    public void setTop(List<Top> top) {
        this.top = top;
    }
}
