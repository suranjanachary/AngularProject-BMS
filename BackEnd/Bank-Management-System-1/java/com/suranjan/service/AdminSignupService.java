package com.suranjan.service;

import com.suranjan.exception.AdminException;
import com.suranjan.model.AdminSignupData;

public interface AdminSignupService {

	public AdminSignupData createNewAdmin(AdminSignupData adminSignupData) throws AdminException;
	
}
