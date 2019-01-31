package com.example.urlproject1.Persistence;


import java.util.Map;
import java.util.TreeMap;

public class TreeMapDataAccess implements DataAccess{

    Map<String, String> map = new TreeMap<>();

    @Override
    public String get(String value) {
        return map.get(value);
    }

    @Override
    public void put(String url, String tinyUrl) {
        map.put(tinyUrl, url);
    }
}
