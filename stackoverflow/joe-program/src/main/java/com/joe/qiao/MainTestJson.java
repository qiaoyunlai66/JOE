package com.joe.qiao;

import com.joe.qiao.drreports.element.PngElement;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import com.joe.qiao.tools.json.JSONHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe Qiao on 04/01/2018.
 */
public class MainTestJson {
    public static void main(String[] args) {
        new MainTestJson().testFromJson();
    }
    
    public void testFromJson(){
        try {
            String json = FileReaderHelper.parseCurrentClassLoaderFile("section.json",this.getClass().getClassLoader());
            List<Object> elements = JSONHelper.fromJsonForBoj(json, ArrayList.class);
            PngElement png = (PngElement) Class.forName("com.joe.qiao.drreports.element.PngElement").newInstance();
            System.out.println(MainTestJson.class.getPackage().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
