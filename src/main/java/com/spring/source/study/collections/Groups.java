package com.spring.source.study.collections;//: strings/Groups.java

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.*;

public class Groups {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\b[a-z]\\S*\\b").matcher(POEM);
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (m.find()) {
            Integer previousNum = map.get(m.group())==null?0:map.get(m.group());
            System.out.println(m.group() + "/" + previousNum);
            map.put(m.group(), previousNum + 1);
            i ++;
        }
        StringBuilder totalCal = new StringBuilder();
        for(String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
            totalCal.append(map.get(key) + " + ");
        }
        totalCal.delete(totalCal.length() - 3, totalCal.length());
        System.out.println("totalCal = " + totalCal);
        System.out.println("不重复数 = " + map.keySet().size());
        System.out.println(i);
    }
} /* Output:
[the slithy toves][the][slithy toves][slithy][toves]
[in the wabe.][in][the wabe.][the][wabe.]
[were the borogoves,][were][the borogoves,][the][borogoves,]
[mome raths outgrabe.][mome][raths outgrabe.][raths][outgrabe.]
[Jabberwock, my son,][Jabberwock,][my son,][my][son,]
[claws that catch.][claws][that catch.][that][catch.]
[bird, and shun][bird,][and shun][and][shun]
[The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
*///:~
