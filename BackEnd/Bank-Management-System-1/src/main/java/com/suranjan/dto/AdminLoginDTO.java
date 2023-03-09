package com.suranjan.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AdminLoginDTO {
	
	@Id
	@NotNull
	private Integer userId;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	public AdminLoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdminLoginDTO(@NotNull String userName, @NotNull String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "AdminLoginDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}

	

	

	
	
	
	
}
