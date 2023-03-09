package com.suranjan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//import lombok.Data;

@Entity
//@Data
public class CustomerSignup {

	@Id
	private Integer customerId;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String phone;
	
	public CustomerSignup() {
		// TODO Auto-generated constructor stub
	}

	public CustomerSignup(Integer customerId, String userName, String password, String email, String phone) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerSignup [customerId=" + customerId + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
}
