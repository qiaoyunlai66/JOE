package com.joe.qiao.tools.json.serialized.inheritance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import com.joe.qiao.tools.fileparser.FileWriterHelper;
import com.joe.qiao.tools.json.JSONHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);

        List<Top> tops =  new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        tops.add(car);
        tops.add(truck);

        Fleet serializedFleet = new Fleet();
        serializedFleet.setVehicles(vehicles);
        serializedFleet.setTop(tops);
        
        try {
            String jsonDataString = JSONHelper.toJsonSerialized(serializedFleet);
            System.out.println("to Json: ");
            FileWriterHelper.writeToPath("/Users/qiaoyunlai/opt/test/tojson.json",jsonDataString);
            System.out.println(jsonDataString);
            Fleet deserializedFleet = JSONHelper.fromJsonDeSerialized(jsonDataString,Fleet.class);
            System.out.println("from Json: ");
            System.out.println(JSONHelper.toJsonSerialized(deserializedFleet));
            System.out.println("success");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
