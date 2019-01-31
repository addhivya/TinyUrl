package com.example.urlproject1.Generator;


import java.util.Random;

public class RandomStringGenerator {

    int value;
    public RandomStringGenerator(int value) {
        this.value = value;
    }

    public String getRandomString() {
        StringBuilder sb = new StringBuilder();
        Random rn = new Random();
        for(int i=0; i<value; i++) {
            int num = rn.nextInt(3);
            int now = 0;
            switch(num) {
                case 1:
                    now = (rn.nextInt(26)+97);
                    sb.append((char)now);
                    break;
                case 2:
                    now = (rn.nextInt(26)+65);
                    sb.append((char)(now));
                    break;
                default:
                    now = (rn.nextInt(10) + 48);
                    sb.append((char)now);
            }
           // System.out.println("String now " + sb.toString() +" " + num +" " + now);
        }

        return sb.toString();
    }

}
