package com.spring.source.study.conn;

public class AccessProtection {

    private String a() {
        return "a";
    }

    protected String b() {
        return "b";
    }

    String c() {
        return "c";
    }
}
