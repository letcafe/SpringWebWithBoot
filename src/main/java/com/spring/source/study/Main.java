package com.spring.source.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws IOException {
        String sentence = "Book on the table but not over there \n" +
                "Almost there";
        System.out.println(reverseWords(sentence));
        System.out.println(reverseCharacters("there"));
    }

    private static String reverseWords(String sentence) {
        HashMap<String, String> wordChain = new HashMap<>();
        try {
            String line = null;
            BufferedReader reader = new BufferedReader(new StringReader(sentence));
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    wordChain.put(word, reverseCharacters(word));
                }
                for (String key : wordChain.keySet()) {
                    sentence = sentence.replace(key, wordChain.get(key));
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentence;
    }

    public static String reverseCharacters(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

}