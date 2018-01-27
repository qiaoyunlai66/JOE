package com.joe.qiao.tools.json.serialized.annotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * @author Joe Qiao
 * @Date 26/01/2018.
 */
@JsonTypeInfo(
   use = JsonTypeInfo.Id.NAME,
   include = JsonTypeInfo.As.PROPERTY,
   property = "class"    
)
@JsonSubTypes({
        @Type(value = Car.class, name = "Car"),
        @Type(value = Truck.class, name = "Trunk"),
        @Type(value = Bike.class, name = "Bike"),
        @Type(value = NoargConstructor.class, name = "NoargConstructor")
})
@JsonIgnoreProperties({"ignoreV2"})
public abstract class Vehicle implements Top {
    private String make;
    private String model;
    private String ignoreVe = "ig";
    private String ignoreV2 = "V2";

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

    public String getIgnoreVe() {
        return ignoreVe;
    }

    public void setIgnoreVe(String ignoreVe) {
        this.ignoreVe = ignoreVe;
    }

    public String getIgnoreV2() {
        return ignoreV2;
    }

    public void setIgnoreV2(String ignoreV2) {
        this.ignoreV2 = ignoreV2;
    }
}
