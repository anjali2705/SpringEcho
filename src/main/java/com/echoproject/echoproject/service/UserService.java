package com.echoproject.echoproject.service;

import java.util.HashMap;

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

	public User findByMobile(String mobile) {
		// TODO Auto-generated method stub
		return repo.findByMobile(mobile);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}
	
	public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
		try {
			if(repo.findByMobile(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			User user = new User();
			user.setName(signupRequest.get("name"));
			user.setEmail(signupRequest.get("email"));
			user.setMobile(signupRequest.get("mobile"));
			user.setPassword(signupRequest.get("password"));
			repo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	
}
