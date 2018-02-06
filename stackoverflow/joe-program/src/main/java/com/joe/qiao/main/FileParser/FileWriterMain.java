package com.joe.qiao.main.FileParser;

import com.joe.qiao.main.FileParser.bean.Animal;
import com.joe.qiao.main.FileParser.bean.House;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import com.joe.qiao.tools.fileparser.FileWriterHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Joe Qiao
 * @Date 06/02/2018.
 */
public class FileWriterMain {
    public static void main(String[] args) {
        new FileWriterMain().testSerializeObject();
    }
    private void testSerializeObject(){
        House house = new House();
        System.out.println("序列化前");
        Animal animal = new Animal("test",house);
        try {
            FileWriterHelper.writeSerializeObjectToCurrentClassPath("serializeAnimal.ser",this.getClass(),animal);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("反序列化后");
        try {
            Animal a = (Animal) FileReaderHelper.getSerializeObjectFromCurrentClassPath("serializeAnimal.ser",this.getClass());
            System.out.println(a.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
