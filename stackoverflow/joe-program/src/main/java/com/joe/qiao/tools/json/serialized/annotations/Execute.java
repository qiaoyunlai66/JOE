package com.joe.qiao.tools.json.serialized.annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.joe.qiao.tools.json.JSONHelper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joe Qiao
 * @Date 27/01/2018.
 */
public class Execute {
    public static void main(String[] args) {
        Execute e = new Execute();
      //  e.testAnnotation();
        e.testMixin();
       // e.testAnnotationIntrospector();
       // e.noArgConstructorTest();
        //e.testList();
    }
    private void testAnnotation(){
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
            String jsonDataString = JSONHelper.toJsonJackSon(serializedFleet);
            System.out.println("to Json... ");
            // FileWriterHelper.writeToPath("/Users/qiaoyunlai/opt/test/tojson.json",jsonDataString);
            System.out.println(jsonDataString);
            Fleet deserializedFleet = JSONHelper.fromJsonJackSon(jsonDataString, Fleet.class);
            System.out.println("from Json: ");
            System.out.println(JSONHelper.toJsonJackSon(deserializedFleet));
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
   
    private void testMixin(){
        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);
        Bike bike = new Bike("bike","green","value");

        List<Top> tops =  new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(bike);
        tops.add(car);
        tops.add(truck);
        tops.add(bike);

        Fleet serializedFleet = new Fleet();
        serializedFleet.setVehicles(vehicles);
        serializedFleet.setTop(tops);
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.addMixIn(Bike.class,BikeMixin.class);
            System.out.println("to Json... ");
            String jsonDataString = mapper.writeValueAsString(serializedFleet);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/Users/qiaoyunlai/opt/test/tojson.json"),serializedFleet);
            // FileWriterHelper.writeToPath("/Users/qiaoyunlai/opt/test/tojson.json",jsonDataString);
            System.out.println(jsonDataString);
            Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);
            System.out.println("from Json: ");
            System.out.println(JSONHelper.toJsonJackSon(deserializedFleet));
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

    private void testAnnotationIntrospector(){
        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);
        Bike bike = new Bike("bike","green","value");

        List<Top> tops =  new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(bike);
        tops.add(car);
        tops.add(truck);
        tops.add(bike);

        Fleet serializedFleet = new Fleet();
        serializedFleet.setVehicles(vehicles);
        serializedFleet.setTop(tops);
        try {
            ObjectMapper mapper=new ObjectMapper();
            ObjectMapper mapper1 = new ObjectMapper();
            mapper.setAnnotationIntrospector(new IgnoranceIntrospector());
            System.out.println("to Json... ");
            String jsonDataString = mapper.writeValueAsString(serializedFleet);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/Users/qiaoyunlai/opt/test/tojson.json"),serializedFleet);
            // FileWriterHelper.writeToPath("/Users/qiaoyunlai/opt/test/tojson.json",jsonDataString);
            System.out.println(jsonDataString);
            Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);
            System.out.println("from Json: ");
            System.out.println(JSONHelper.toJsonJackSon(deserializedFleet));
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

    private void noArgConstructorTest(){
        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);
        Bike bike = new Bike("bike","green","value");
        NoargConstructor noargConstructor = new NoargConstructor("noarg","blue");
        
        List<Top> tops =  new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        vehicles.add(bike);
        vehicles.add(noargConstructor);
        tops.add(car);
        tops.add(truck);
        tops.add(bike);
        tops.add(noargConstructor);

        Fleet serializedFleet = new Fleet();
        serializedFleet.setVehicles(vehicles);
        serializedFleet.setTop(tops);
        try {
            ObjectMapper mapper=new ObjectMapper();
            System.out.println("to Json... ");
            String jsonDataString = mapper.writeValueAsString(serializedFleet);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/Users/qiaoyunlai/opt/test/tojson.json"),serializedFleet);
            // FileWriterHelper.writeToPath("/Users/qiaoyunlai/opt/test/tojson.json",jsonDataString);
            System.out.println(jsonDataString);
            Fleet deserializedFleet = mapper.readValue(jsonDataString, Fleet.class);
            System.out.println("from Json: ");
            System.out.println(JSONHelper.toJsonJackSon(deserializedFleet));
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

    /**
     * unmarshall json array to List<Interface>
     */
    private void testList(){
        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);

        List<Top> tops =  new ArrayList<>();
        tops.add(car);
        tops.add(truck);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionLikeType collectionLikeType = objectMapper.getTypeFactory().constructCollectionType(
                    List.class, Top.class);
            /**
             * 以下两种皆可以
             */
          //  String jsonDataString = objectMapper.writerFor(collectionLikeType).writeValueAsString(tops);
            String jsonDataString = objectMapper.writerFor(new TypeReference<List<Top>>() {}).writeValueAsString(tops);
            System.out.println("to Json... ");
            System.out.println(jsonDataString);
            /**
             * 以下两种皆可以
             */
            List<Top> deserializedFleet = objectMapper.readValue(jsonDataString, collectionLikeType);
           // List<Top> deserializedFleet = objectMapper.readValue(jsonDataString, new TypeReference<List<Top>>() {});
            System.out.println("from Json: ");
            System.out.println(JSONHelper.toJsonJackSon(deserializedFleet));
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

/**
 * json will ignore
 *       Vehicle.class && m.getName() == "model" ==true
 *     和 m.getDeclaringClass() == Car.class ==true
 *     和 m.getName() == "towingCapacity"==true
 *     和 super.hasIgnoreMarker(m) == true 的情况
 *  不能用这个设置get object from json的情况，会报错找不到 Car.class 因为mapper 会忽略 Car.class 
 *    (可以通过去掉 m.getDeclaringClass() == Car.class 这个选项来解决这个 报错问题
 */    
class IgnoranceIntrospector extends JacksonAnnotationIntrospector {
    public boolean hasIgnoreMarker(AnnotatedMember m) {
        return m.getDeclaringClass() == Vehicle.class && m.getName() == "model"
                || m.getDeclaringClass() == Car.class
                || m.getName() == "towingCapacity"
                || super.hasIgnoreMarker(m);
    }
}