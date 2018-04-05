package com.edoctor.service;

public interface RedisService {

    void setKeyValue(String key, String value);

    String getKeyValue(String tel);

    void deleteKey(String key);

}
