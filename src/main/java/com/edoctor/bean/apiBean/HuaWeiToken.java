package com.edoctor.bean.apiBean;

import java.time.Instant;

public class HuaWeiToken {
    String token;
    Instant getTokenTime;

    public HuaWeiToken() {
    }

    public HuaWeiToken(String token, Instant getTokenTime) {
        this.token = token;
        this.getTokenTime = getTokenTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getGetTokenTime() {
        return getTokenTime;
    }

    public void setGetTokenTime(Instant getTokenTime) {
        this.getTokenTime = getTokenTime;
    }

    @Override
    public String toString() {
        return "HuaWeiToken{" +
                "token='" + token + '\'' +
                ", getTokenTime=" + getTokenTime +
                '}';
    }
}
