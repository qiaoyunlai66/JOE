package com.joe.qiao.drreports.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.joe.qiao.drreports.core.Element;
import com.joe.qiao.drreports.core.Parser;
import com.joe.qiao.drreports.core.Sectional;
import org.apache.commons.lang.StringUtils;
import java.io.IOException;
import java.util.List;

/**
 * @author Joe Qiao
 * @Date 28/01/2018.
 */
public class JsonAnnotationParser implements Parser {
    private List<Sectional> sectionalList;
    private String json;
    public JsonAnnotationParser(String json){
        this.json = json;
    }
    @Override
    public boolean parse() {
        if(StringUtils.isEmpty(json)){
            System.out.println("Read JSON error: json none");
            return false;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        CollectionLikeType collectionLikeType = objectMapper.getTypeFactory().constructCollectionType(
                List.class, Sectional.class);
        try {
            sectionalList = objectMapper.readValue(json, collectionLikeType);
        } catch (IOException e) {
            System.out.println("Read JSON error:"+e.getMessage());
            e.printStackTrace();
        }
        if(sectionalList!=null&&sectionalList.size()>0){
            for(Sectional sectional:sectionalList){
                if(!sectional.integrate()){
                    System.out.println("integrate failed:");
                }
            }
        }
        return true;
    }

    @Override
    public Object getResult(Object o) {
        return sectionalList;
    }
}
