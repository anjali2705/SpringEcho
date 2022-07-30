package com.echoproject.echoproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto Increment Id
	private int id;
	private String address;
	private String created_at;
	private String email;
	private String is_email_verified;
    private String mobile;
    private String name;
	private String password;
	private String type;
	
	public User(){}
	public User(int id, String address, String created_at, String email, String is_email_verified, String mobile,
			String name, String password, String type) {
		super();
		this.id = id;
		this.address = address;
		this.created_at = created_at;
		this.email = email;
		this.is_email_verified = is_email_verified;
		this.mobile = mobile;
		this.name = name;
		this.password = password;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIs_email_verified() {
		return is_email_verified;
	}
	public void setIs_email_verified(String is_email_verified) {
		this.is_email_verified = is_email_verified;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
