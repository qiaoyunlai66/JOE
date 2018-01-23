package com.joe.qiao.drreports.impl;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.core.FileParser;
import com.joe.qiao.drreports.core.Sectional;
import com.joe.qiao.tools.fileparser.FileReaderHelper;
import com.joe.qiao.tools.json.JSONHelper;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Joe Qiao
 * @Date 22/01/2018.
 */
public class JsonFileParser implements FileParser {
    private List<Sectional> sectionalList;
    private String path;
    final static String ELEMENTS = "elements";
    final static String CLASS = "class";
    public JsonFileParser(String path){
        this.path = path;
    }
    @Override
    public boolean parse() {
        if(StringUtils.isEmpty(path)){
            System.out.println("Read JSON file error: path none");
            return false;
        }
        String json = null;
        try {
            json = FileReaderHelper.parseFile(path);
        } catch (IOException e) {
            System.out.println("read json file error: "+path);
            e.printStackTrace();
            return false;
        }
        JSONArray sections= new JSONArray(json);
         if(sections==null||sections.length()<1){
             System.out.println("Read JSON file error: format error...");
         }
        for(int i=0;i<sections.length();i++){
             JSONObject section = (JSONObject)sections.get(i);
             JSONArray elements = section.getJSONArray(ELEMENTS);
            Sectional sectional = null;
            try {
                sectional = getSection(elements);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(sectional==null){
                 return false;
             }
             if(sectionalList == null){
                sectionalList= new ArrayList<>();
             }
             if(sectional!=null)sectionalList.add(sectional);
        }
        return true;
    }

    private Sectional getSection(JSONArray elements) throws Exception {
        Sectional sectional = new NormalSectional();
        if(elements==null){
            System.out.println("Error to parse elements: "+elements);
            return null;
        }
        for(int i= 0;i<elements.length();i++){
            JSONObject eleObject = elements.getJSONObject(i);
            String className = eleObject.getString(CLASS);
            Class clazz = Class.forName(className);
            Element element = (Element) JSONHelper.fromJsonForBoj(eleObject.toString(),clazz);
            if(element!=null)sectional.addElement(element);
        }
        return sectional;
    }
    
    @Override
    public List<Sectional> getSectionalList() {
        return sectionalList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
