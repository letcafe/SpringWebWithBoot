package com.edoctor.dao;

import com.edoctor.bean.User;

import java.util.List;

public interface UserDao {

    void insert(User user);

    void updateByPrimaryKeySelective(User user);

    void deleteByPrimaryKey(String userId);

    User selectByPrimaryKey(String userId);

    List<User> getUserList();

    Long count();
}
