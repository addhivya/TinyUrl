package com.example.urlproject1.Persistence;

import java.util.HashMap;
import java.util.Map;

public class MapPresistence implements DataAccess{

    Map<String, String> map = new HashMap<>();

    @Override
    public String get(String value) {
        return map.get(value);
    }

    @Override
    public void put(String url, String tinyUrl) {
        map.put(tinyUrl, url);
    }
}
