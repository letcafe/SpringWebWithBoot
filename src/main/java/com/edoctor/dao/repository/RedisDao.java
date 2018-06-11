package com.edoctor.dao.repository;

public interface RedisDao {
    void setKeyValue(String key, String value);

    String getKeyValue(String tel);

    void deleteKey(String key);
}
