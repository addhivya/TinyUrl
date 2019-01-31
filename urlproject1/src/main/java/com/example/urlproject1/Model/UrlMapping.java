package com.example.urlproject1.Model;

import lombok.Data;

@Data
public class UrlMapping {
    String actualUrl;
    String tinyUrl;

    public String getActualUrl() {
        return actualUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public UrlMapping(String actualUrl, String tinyUrl) {
        this.actualUrl = actualUrl;
        this.tinyUrl = tinyUrl;
    }
}
