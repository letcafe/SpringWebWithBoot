package com.spring.source.study.collections;//: strings/JGrep.java

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {

    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IDEA_proj\\Thinking_in_Java_SouceCode\\control\\ForEachInt.java";
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = null;
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String tmpStr = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((tmpStr = bufferedReader.readLine()) != null) {
            stringBuilder.append(tmpStr).append("\n");
            matcher = pattern.matcher(stringBuilder);
        }
        Set<String> set = new HashSet<>();
        while (matcher.find()) {
            set.add(matcher.group());
        }
        for(String s : set) {
            System.out.println("[result]:" + s);
        }
    }

}
