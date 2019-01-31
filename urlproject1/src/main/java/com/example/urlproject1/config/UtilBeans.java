package com.example.urlproject1.config;

import com.example.urlproject1.Generator.RandomStringGenerator;
import com.example.urlproject1.Persistence.DataAccess;
import com.example.urlproject1.Persistence.TreeMapDataAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UtilBeans {

    @Bean("one")
    RandomStringGenerator randomStringGenerator(){
        return new RandomStringGenerator(7);
    }

    @Bean("two")
    RandomStringGenerator randomStringGenerator1(){
        return new RandomStringGenerator(10);
    }

    @Bean
    DataAccess access() {
        return new TreeMapDataAccess();
    }



}
