package com.edoctor.util;


public class NumUtil {

    public static Long exchangeHeadToEnd(Long number) {
        String strNum = String.valueOf(number);
        char[] charArray = strNum.toCharArray();
        char[] targetArray = new char[strNum.length()];
        for(int i = 0; i < charArray.length; i++) {
            targetArray[charArray.length - i - 1] = charArray[i];
        }
        String targetValue = new String(targetArray);
        return Long.valueOf(targetValue);
    }
}
