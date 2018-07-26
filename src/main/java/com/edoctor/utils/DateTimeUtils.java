package com.edoctor.utils;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static Long getDateTime(String HuaWeiTime) {
        String replacedTime = HuaWeiTime.replaceAll("T|Z","");
        System.out.println("replacedTime:" + replacedTime);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime eventStringTime = LocalDateTime.parse(replacedTime, df);
        Timestamp eventStartTimestamp = Timestamp.valueOf(eventStringTime);
        return eventStartTimestamp.getTime();
    }
}
