package com.suranjan.dto;

import javax.validation.constraints.NotNull;



//@Data
//@NoArgsConstructor
public class CustomerLoginDTO {

	@NotNull
	private String userName;
	@NotNull
	private String password;
	
	public CustomerLoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerLoginDTO(@NotNull String userName, @NotNull String password) {
		super();
		this.userName = userName;
		this.password = password;
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
		return "CustomerLoginDTO [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
