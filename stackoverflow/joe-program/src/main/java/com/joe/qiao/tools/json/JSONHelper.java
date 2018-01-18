package com.joe.qiao.tools.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe Qiao on 19/12/2017.
 */
public class JSONHelper {
    //API JACKSON
    public static String toJson(Object obj) throws Exception{
        if(obj == null){
            return null;
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        String serialized = mapper.writeValueAsString(obj);
        return serialized;
    }

    //API gson
    public static <T> List<T> fromJson(String json, Class<T> clazz) throws Exception{
        List<T> rets = (List<T>) new Gson().fromJson(json, new TypeToken<List<T>>(){}.getType());
        return rets;
    }

    /**
     * @deprecated
     * @API gson
     */
    public static <T> List<T> fromJsonForObjList(String json, Class<T> clazz) throws Exception {
        List<T> ret = new ArrayList<>();
        if(StringUtils.isBlank(json)){
            return ret;
        }
        List list = JSONHelper.fromJsonForBoj(json, ArrayList.class);
        for (Object obj : list) {
            T item = JSONHelper.fromJsonForBoj(JSONHelper.toJson(obj), clazz);
            ret.add(item);
        }
        return ret;
    }
    //API gson
    public static <T> T fromJsonForBoj(String json, Class<T> clazz) throws Exception {
        if(StringUtils.isBlank(json)){
            return null;
        }
        T obj = new Gson().fromJson(json, clazz);
        return obj;
    }
}
