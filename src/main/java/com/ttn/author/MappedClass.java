package com.ttn.author;
import org.apache.sling.scripting.sightly.pojo.Use;


import javax.script.Bindings;
import java.util.HashMap;
import java.util.Map;

public class MappedClass implements Use {

    private Map<String, String> map;

    @Override
    public void init(Bindings bindings) {

        map = new HashMap<String, String>();

        map.put("1", "Vaibhav");
        map.put("2" , "Utkarsh");
        map.put("3" , "Akash");
        map.put("4" , "Ayush");
        map.put("5" , "Amit");
        map.put("6" , "Abhishek");


    }

    public Map<String, String> getMap() {
        return map;
    }
}