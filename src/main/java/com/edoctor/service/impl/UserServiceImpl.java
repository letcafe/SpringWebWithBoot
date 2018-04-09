package com.edoctor.service.impl;

import com.edoctor.bean.User;
import com.edoctor.dao.UserDao;
import com.edoctor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserById(Integer user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public void updateUserSexById(Integer user_id, String sex) {
        userDao.updateUserSexById(user_id, sex);
    }

    @Override
    public void deleteUserById(Integer user_id) {
        userDao.deleteUserById(user_id);
    }

    @Override
    public void addOneUser(Integer user_id, String name, String dep_id, String sex) {
        userDao.addOneUser(user_id, name, dep_id, sex);
    }

    @Override
    public long count() {
        return userDao.count();
    }
}
