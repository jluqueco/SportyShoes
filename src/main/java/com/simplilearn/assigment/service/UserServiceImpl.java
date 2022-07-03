package com.simplilearn.assigment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.assigment.model.User;
import com.simplilearn.assigment.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User save(User theUser) {
		// TODO Auto-generated method stub
		return userRepository.save(theUser);
	}

	@Override
	public User findById(long theUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(theUser).get();
	}

	@Override
	public User deleteById(long theUser) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(theUser);
		
		return null;
	}

}
