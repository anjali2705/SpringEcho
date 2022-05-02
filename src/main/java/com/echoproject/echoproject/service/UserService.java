package com.echoproject.echoproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echoproject.echoproject.model.User;
import com.echoproject.echoproject.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	public User saveUser(User user){
		
		return repo.save(user);
		
	}
	
	public User fetchuserByEmailId(String emailId){
		return repo.findByEmail(emailId);
	}
	
	public User fetchuserByEmailIdAndPassword(String emailId, String password){
		return repo.findByEmailAndPassword(emailId, password);
	}

	
}
