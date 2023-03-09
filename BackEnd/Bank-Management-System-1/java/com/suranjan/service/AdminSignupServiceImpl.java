package com.suranjan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suranjan.exception.AdminException;
import com.suranjan.model.AdminSignupData;
import com.suranjan.repository.AdminSignupDao;
 
@Service
public class AdminSignupServiceImpl implements AdminSignupService {

	@Autowired(required = true)
	private AdminSignupDao adminSignupDao;
	
	@Override
	public AdminSignupData createNewAdmin (AdminSignupData adminSignUpData) throws AdminException  {
		
		
		Optional<AdminSignupData> signupData = adminSignupDao.findByUserName(adminSignUpData.getUserName());
		
		if(signupData.isPresent()) {
			
			throw new AdminException("Already an Admin is present with this User Name");
		}
		
		AdminSignupData newSignedupAdmin = adminSignupDao.save(adminSignUpData);
		
		return newSignedupAdmin;
	}

}
