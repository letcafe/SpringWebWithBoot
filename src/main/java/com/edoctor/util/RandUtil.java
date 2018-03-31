package com.edoctor.util;


import java.util.Random;

public class RandUtil {

    private static Random random;

    static {
        random = new Random();
    }

    public static String randNumber(int length) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < length; i++) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }

}
