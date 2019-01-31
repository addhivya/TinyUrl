package com.example.urlproject1.Controller;

import com.example.urlproject1.Generator.RandomStringGenerator;
import com.example.urlproject1.Model.UrlMapping;
import com.example.urlproject1.Persistence.DataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class FullUrlController {

    private static final String DOMAIN = "http://localhost:8080/";

    @Qualifier("one")
    @Autowired
    RandomStringGenerator randomGenerator;

    @Qualifier("two")
    @Autowired
    RandomStringGenerator randomStringGenerator;

    @Autowired
    DataAccess access;

    @CrossOrigin(origins = {"*"})
    @RequestMapping(method=RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/{url}")
    public UrlMapping getShortPut(@PathVariable String url) {
        return new UrlMapping(url, encode(url));
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/{tinyUrl}")
    public UrlMapping getShort(@PathVariable String tinyUrl){
        return new UrlMapping(decode(tinyUrl),tinyUrl);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, value = "/{tinyUrl}")
    public UrlMapping getShortPost(@PathVariable String tinyUrl){
        return new UrlMapping(decode(tinyUrl),tinyUrl);
    }

    public String decode(String tinyUrl){
        String actualUrl = tinyUrl.replace(DOMAIN, "");
        String s=access.get(actualUrl);
        return s;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random random = new Random();
        String str = null;
        if(random.nextBoolean()) {
            str = randomGenerator.getRandomString();
        } else {
            str = randomStringGenerator.getRandomString();
        }
        while(access.get(str)!=null) {
            if(random.nextBoolean()) {
                str = randomGenerator.getRandomString();
            } else {
                str = randomStringGenerator.getRandomString();
            }
        }
        access.put(longUrl, str);
        return DOMAIN+str;
    }
}
