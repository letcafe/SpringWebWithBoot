package com.edoctor.service.impl;

import com.edoctor.dao.RedisDao;
import com.edoctor.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisDao redisDao;

    @Override
    public void setKeyValue(String key, String value) {
        redisDao.setKeyValue(key, value);
    }

    @Override
    public String getKeyValue(String tel) {
        return redisDao.getKeyValue(tel);
    }

    @Override
    public void deleteKey(String key) {
        redisDao.deleteKey(key);
    }
}
