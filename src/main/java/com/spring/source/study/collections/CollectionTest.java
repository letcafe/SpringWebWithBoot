package com.spring.source.study.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionTest{

    public static void main(String[] args){
        List<String> patterns = new ArrayList<>();
        patterns.addAll(Arrays.asList("(?i)((^[aeiou]|(\\s+[aeiou]))\\w+?[aeiou]\\b)"));
        for(String pattern : patterns) {
            Pattern p = Pattern.compile(pattern);
            Matcher matcher = p.matcher("Arline ate eight apples and one orange while Anita hadn't");
            while(matcher.find()) {
                System.out.println("[pattern]" + pattern + " => " + matcher.group());
            }
        }
    }
}