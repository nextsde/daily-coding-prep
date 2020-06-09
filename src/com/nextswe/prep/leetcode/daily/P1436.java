package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1436 {
    static class CityInfo{
        String name;
        boolean destination;
        int frequency;
        String source;
    }
    public String destCity(List<List<String>> paths) {
        Map<String, CityInfo> map = new HashMap<>();
        for(List<String> p : paths){
            String source = p.get(0);
            CityInfo sc = null;
            if(map.containsKey(source)){
                sc = map.get(source);
            }else{
                sc = new CityInfo();
                map.put(source, sc);
            }
            sc.name = source;
            sc.destination = false;
            sc.frequency = sc.frequency+1;
            sc.source = null;

            String destination = p.get(1);
            CityInfo dc = null;
            if(map.containsKey(destination)){
                dc = map.get(destination);
            }else{
                dc = new CityInfo();
                map.put(destination, dc);
            }
            dc.name = destination;
            dc.destination = true;
            dc.frequency = dc.frequency+1;
            dc.source = source;
        }
        for(String key: map.keySet()){
            CityInfo cc = map.get(key);
            if(cc.destination && cc.frequency==1){
                return key;
            }
        }
        return null;
    }


}
