package mapsDemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) {
       // Map<String,String> map=new HashMap<>();
       // Map<String,String> map=new LinkedHashMap<>();
        Map<String,String> map=new TreeMap<>();
        map.put("fname","Sachin");
        map.put("lname","Gupta");
        map.put("Team","MI");
        map.put("Position","Mentor");
        map.put("fname","Sourav");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println((map.entrySet()));

        System.out.println("----------------------------");

        for(String key: map.keySet()){
            System.out.println(key+" : " + map.get(key));
        }

        System.out.println("----------------------------");

        for(String value:map.values()){
            System.out.println(value);
        }

        System.out.println("----------------------------------");

        map.keySet().stream().forEach((String key)-> System.out.println(key + " : " +map.get(key)));

        System.out.println("----------------------------------");

        map.values().stream().forEach((String value)-> System.out.println(value));

        System.out.println("-----------------------------------");

        map.entrySet().stream().forEach((Map.Entry<String,String> entry)-> System.out.println(entry.getKey()+ " : " + entry.getValue()));

        System.out.println("------------------------------------");
        map.forEach((key,value)-> System.out.println(key+ " : " + value));

    }
}
