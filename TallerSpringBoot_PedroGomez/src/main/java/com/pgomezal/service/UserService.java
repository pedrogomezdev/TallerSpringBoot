package com.pgomezal.service;

import java.util.List;

import com.pgomezal.entities.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public User findById(Long id);
	public User save(User user);
	public User delete(Long id);
	public User update(User user);
	

}
