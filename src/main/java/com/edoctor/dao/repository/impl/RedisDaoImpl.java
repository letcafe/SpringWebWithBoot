package com.edoctor.dao.repository.impl;

import com.edoctor.bean.Device;
import com.edoctor.dao.repository.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired
    RedisTemplate<String, Device> redisObj;

    @Override
    public void setKeyValue(String key, String value) {
        Device device = new Device();
        device.setOwner_id(1221312);
        device.setDeviceType("SmartDevice");
        redisObj.opsForValue().set(key, device);
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
