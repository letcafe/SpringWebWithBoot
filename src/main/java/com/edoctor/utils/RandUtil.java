package com.edoctor.utils;


import org.springframework.jmx.export.annotation.ManagedOperation;

import java.util.Random;


public class RandUtil {

    private static Random random;

    static {
        random = new Random();
    }

    @ManagedOperation
    public static String randNumber(int length) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < length; i++) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }

}
