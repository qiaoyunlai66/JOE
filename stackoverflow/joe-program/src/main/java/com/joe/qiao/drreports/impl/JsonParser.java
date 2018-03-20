package com.joe.qiao.drreports.impl;

import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.core.Parser;
import com.joe.qiao.drreports.core.Sectional;
import com.joe.qiao.drreports.section.CoverPageSectional;
import com.joe.qiao.drreports.section.TOCSectional;
import com.joe.qiao.domain.json.JSONHelper;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Joe Qiao
 * @Date 22/01/2018.
 */
public class JsonParser implements Parser {
    private CoverPageSectional cPSectional;
    private List<Sectional> sectionalList;
    private String json;
    final static String ELEMENTS = "elements";
    final static String CLASS = "class";
    public JsonParser(String json){
        this.json = json;
    }
    @Override
    public boolean parse() {
        if(StringUtils.isEmpty(json)){
            System.out.println("Read JSON error: json none");
            return false;
        }
        JSONArray sections= new JSONArray(json);
         if(sections==null||sections.length()<1){
             System.out.println("Read JSON file error: format error...");
         }
        readGlobal(sections.getJSONObject(0));
        try {
            readCoverPage(sections.getJSONObject(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=2;i<sections.length();i++){
             JSONObject section = (JSONObject)sections.get(i);
            Sectional sectional = null;
            try {
                sectional = readTOCSection(section);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(sectional!=null){
                if(sectionalList == null){
                    sectionalList= new ArrayList<>();
                }
                sectionalList.add(sectional);
            }
        }
        return true;
    }

    private boolean readCoverPage(JSONObject jsonObject) throws Exception {
        JSONArray elements = jsonObject.getJSONArray(ELEMENTS);
        if(elements==null){
            System.out.println("Error to parse elements: "+elements);
            return false;
        }
        for(int i= 0;i<elements.length();i++){
            JSONObject eleObject = elements.getJSONObject(i);
            String className = eleObject.getString(CLASS);
            Class clazz = Class.forName(className);
            Element element = (Element) JSONHelper.fromJsonForBoj(eleObject.toString(),clazz);
            if(cPSectional ==null){
                cPSectional = new CoverPageSectional();
            }
            if(element!=null)cPSectional.addElement(element);
        }
        return true;
    }

    private boolean readGlobal(JSONObject jsonObject) {
       return false;
    }

    /**
     * @param jsonObject
     *                     
     * @return
     * @throws Exception
     */
    private Sectional readTOCSection(JSONObject jsonObject) throws Exception {
        String clazz = jsonObject.getString(CLASS);
        if(StringUtils.isEmpty(clazz)){
            System.out.println("Error read class from section : " + jsonObject.toString());
        }
        TOCSectional sectional = (TOCSectional) Class.forName(clazz).newInstance();
        sectional.setName(jsonObject.getString("name"));
        sectional.setHeading(getElement(jsonObject.getJSONObject("heading")));
        sectional.setElements(getElements(jsonObject.getJSONArray("elements")));
        if(jsonObject.has("subSections"))
        sectional.setSubSections(getSections(jsonObject.getJSONArray("subSections")));
        return sectional;
    }
    
    public List<Sectional> getSections(JSONArray jsonArray) throws Exception {
        List<Sectional> sections = null;
        if(jsonArray == null)return null;
        for(int i = 0;i<jsonArray.length();i++){
            Sectional sectional = readTOCSection(jsonArray.getJSONObject(i));
            if(sectional!=null){
                if(sections==null)sections= new ArrayList<>();
                sections.add(sectional);
            }
        }
        return sections;
    }
    
    public List<Element> getElements(JSONArray jsonArray){
        List<Element> elements = null;
        if(jsonArray==null)return null;
        for(int i= 0;i<jsonArray.length();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Element element = getElement(jsonObject);
            if(element!=null){
                if(elements==null)elements=new ArrayList<>();
                elements.add(element);
            }
        }
        return elements;
    }
    
    public Element getElement(JSONObject jsonObject) {
        try {
            if(jsonObject==null){
                return null;
            }
            String className = jsonObject.getString(CLASS);
            Class clazz = Class.forName(className);
            Element element = (Element) JSONHelper.fromJsonForBoj(jsonObject.toString(), clazz);
            return element;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error get element from json: "+jsonObject.toString());
            return null;
        }
    }
    
    @Override
    public Object getResult(Object o) {
        return sectionalList;
    }
    
    public Sectional getcPSectional() {
        return cPSectional;
    }
}
