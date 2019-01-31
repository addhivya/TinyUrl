package com.example.urlproject1.Persistence;

public interface DataAccess {
    public String get(String value);
    public void put(String url, String tinyUrl);
}
