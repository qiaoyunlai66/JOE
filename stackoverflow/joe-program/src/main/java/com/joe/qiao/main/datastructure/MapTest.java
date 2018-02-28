package com.joe.qiao.main.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joe Qiao on 06/01/2018.
 */
public class MapTest {
    public static void main(String[] args) {
        System.out.println(hash("qiao"));
        System.out.println();
        System.out.println(3^4);
        System.out.println(18>>>16);
        new MapTest().testSameKey();
    }
    
    private void testSameKey(){
        Map<String,String> map = new HashMap();
        map.put(null,null);
        map.put("qiao","qiao");
        map.put("qiao","yun");
        map.put(null,"yun");
        map.remove(null);
        map.remove("qiao");
        System.out.println(map.get(null)+map.get("qiao"));
    }
    static final int hash(Object key) {
        int h;
        h=key.hashCode();
        int h1= h>>>16;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
