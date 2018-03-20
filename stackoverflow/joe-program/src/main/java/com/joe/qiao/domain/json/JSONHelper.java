package com.joe.qiao.domain.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.util.*;

/**
 * Created by Joe Qiao on 19/12/2017.
 */
public class JSONHelper {
    /**
     * API JACKSON
     * @param obj
     * @return
     * @throws IOException
     */
    public static String toJsonJackSon(Object obj) throws Exception{
        if(obj == null){
            return null;
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String serialized = mapper.writeValueAsString(obj);
        return serialized;
    }

    /**
     * API JACKSON
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T fromJsonJackSon(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.readValue(json,clazz);
    }

    /**
     * API JACKSON serialize object to json support interface
     * @param obj
     * @return
     * @throws Exception
     */
    public static String toJsonSerialized(Object obj) throws Exception{
        if(obj == null){
            return null;
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.enableDefaultTyping();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String serialized = mapper.writeValueAsString(obj);
        return serialized;
    }
    
    /**
     * API JACKSON deserialize json to object support interface
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T fromJsonDeSerialized(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        mapper.enableDefaultTyping();
        return mapper.readValue(json,clazz);
    }

    
    
    /**
     * @deprecated 
     *  API gson
     */
    public static <T> List<T> fromJson(String json, Class<T> clazz) throws Exception{
        List<T> rets = (List<T>) new Gson().fromJson(json, new TypeToken<List<T>>(){}.getType());
        return rets;
    }

    /**
     * @API gson
     */
    public static <T> List<T> fromJsonForObjList(String json, Class<T> clazz) throws Exception {
        List<T> ret = new ArrayList<>();
        if(StringUtils.isBlank(json)){
            return ret;
        }
        List list = JSONHelper.fromJsonForBoj(json, ArrayList.class);
        for (Object obj : list) {
            T item = JSONHelper.fromJsonForBoj(JSONHelper.toJsonJackSon(obj), clazz);
            ret.add(item);
        }
        return ret;
    }

    /**
     * API gson
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T fromJsonForBoj(String json, Class<T> clazz) throws Exception {
        if(StringUtils.isBlank(json)){
            return null;
        }
        T obj = new Gson().fromJson(json, clazz);
        return obj;
    }

    public static Map<String, String> getMapFromJson(String json, String keyName, String valName) throws Exception {
        Map<String, String> ret = new HashMap<>();
        if(StringUtils.isEmpty(json)){
            return ret;
        }
        JSONArray jsonArray=new JSONArray(json);
        for(Iterator it = jsonArray.iterator(); it.hasNext();){
            JSONObject jsonObejct= (JSONObject) it.next();
            ret.put(jsonObejct.get(keyName).toString(),jsonObejct.get(valName).toString());
        }
        return ret;
    }
}
