package com.echoproject.echoproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.echoproject.echoproject.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {



	public User findByEmailAndPassword(String emailId, String password);

	public User findByEmail(String emailId);

	
}
