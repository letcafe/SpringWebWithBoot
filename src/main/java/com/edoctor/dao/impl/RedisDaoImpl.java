package com.edoctor.dao.impl;

import com.edoctor.bean.User;
import com.edoctor.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired
    RedisTemplate<String, User> redisObj;

    @Override
    public void setKeyValue(String key, String value) {
        User user = new User();
        redisObj.opsForValue().set(key, user);
    }

    @Override
    public String getKeyValue(String key) {
        return redisObj.opsForValue().get(key).toString();
    }

    @Override
    public void deleteKey(String key) {
        redisObj.delete(key);
    }
}
