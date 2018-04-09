package com.edoctor.service;

import com.edoctor.bean.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserById(Integer user_id);

    void updateUserSexById(Integer user_id, String sex);

    void deleteUserById(Integer user_id);

    void addOneUser(Integer user_id, String name, String dep_id, String sex);

    long count();
}
