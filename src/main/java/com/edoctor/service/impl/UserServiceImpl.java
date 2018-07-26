package com.edoctor.service.impl;

import com.edoctor.bean.User;
import com.edoctor.dao.UserDao;
import com.edoctor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.insert(user);
	}

	@Override
	public void updateUserById(User user) {
		userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteUserById(String userId) {
		userDao.deleteByPrimaryKey(userId);
	}

	@Override
	public User getUserById(String userId) {
		
		return userDao.selectByPrimaryKey(userId);
	}
	
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public Long count() {
		return userDao.count();
	}

}
