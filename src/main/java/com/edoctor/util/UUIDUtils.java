package com.edoctor.util;

import java.util.UUID;

public class UUIDUtils {

    public static String getOneUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
