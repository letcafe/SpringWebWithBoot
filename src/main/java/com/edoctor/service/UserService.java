package com.edoctor.service;


import com.edoctor.bean.User;

import java.util.List;

public interface UserService {

	public void saveUser(User user);
	
	public void updateUserById(User user);
	
	public void deleteUserById(String userId);
	
	public User getUserById(String userId);
	
	public List<User> getUserList();

    Long count();
}
