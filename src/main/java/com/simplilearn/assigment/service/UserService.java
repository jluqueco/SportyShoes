package com.simplilearn.assigment.service;

import java.util.List;

import com.simplilearn.assigment.model.User;

public interface UserService {
	public List<User> findAll();
	public User save(User theUser);
	public User findById(long theUser);
	public User deleteById(long theUser);
}
