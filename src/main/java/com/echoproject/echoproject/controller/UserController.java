package com.echoproject.echproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.echoproject.echoproject.model.User;
import com.echoproject.echoproject.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:3000")
    public User registerUser(@RequestBody User user) throws Exception{
		
//		if(userEmailId != null){
//			User userobj =service.fetchuserByEmailId(userEmailId);
//			if(userobj != null){
//				throw new Exception("User is already exist!!");
//			}
//		}
    	User userObj = null;
    	userObj = service.saveUser(user);
    	return userObj;
    }
	
	 

	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:3000")
	public User loginUser(@RequestBody User user) throws Exception{
		   String userEmailId = user.getEmail();
		   String userPassword = user.getPassword();
		   User userObj=null;
		   if(userEmailId != null & userPassword!= null){
			   userObj = service.fetchuserByEmailIdAndPassword(userEmailId, userPassword);
		   }
		   if(userObj == null){
			   throw new Exception("Bad Credential");
		   }
		   return userObj;
	}
}
