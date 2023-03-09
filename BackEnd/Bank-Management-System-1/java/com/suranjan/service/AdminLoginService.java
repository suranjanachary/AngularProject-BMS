package com.suranjan.service;

import com.suranjan.dto.AdminLoginDTO;
import com.suranjan.exception.LoginException;
import com.suranjan.model.CurrentUserSession;

public interface AdminLoginService {

	public String loginAdmin(AdminLoginDTO adminLoginDTO) throws LoginException;
	
	public String logOutAdmin(String key) throws LoginException;
	
}
