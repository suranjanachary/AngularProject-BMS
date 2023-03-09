package com.suranjan.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suranjan.dto.AdminLoginDTO;
import com.suranjan.exception.LoginException;
import com.suranjan.model.AdminSignupData;
import com.suranjan.model.CurrentUserSession;
import com.suranjan.repository.AdminLoginDTODao;
import com.suranjan.repository.AdminSignupDao;
import com.suranjan.repository.CurrentUserSessionDao;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminSignupDao adminSignupDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private AdminLoginDTODao adminLoginDTODao;
	
	@Override
	public String loginAdmin(AdminLoginDTO adminLoginDTO) throws LoginException {
		
		
		Optional<AdminSignupData> opt = adminSignupDao.findById(adminLoginDTO.getUserId());
		
		if(!opt.isPresent())
		{
			throw new LoginException("Invalid Login UserId");
		}
		
		AdminSignupData newSignedUpData = opt.get();
		
		Integer newSignUpId = newSignedUpData.getAdminId();
		
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDao.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			
			throw new LoginException("User Already login with this UserId");
		}
		
		if((newSignedUpData.getAdminId() == adminLoginDTO.getUserId()) && (newSignedUpData.getPassword().equals(adminLoginDTO.getPassword())))
		{
			
			RandomNumberService ran = new RandomNumberService();
			
		 	String key =ran.RandomNumber();
			
			CurrentUserSession currentUserSession = new CurrentUserSession();
			
			currentUserSession.setUserId(newSignUpId);
			currentUserSession.setUserName(newSignedUpData.getUserName());
			currentUserSession.setUuid(key);
			currentUserSession.setLocalDateTime(LocalDateTime.now());
			
			currentUserSessionDao.save(currentUserSession);
			adminLoginDTODao.save(adminLoginDTO);
			
			System.out.println(currentUserSession.toString());
			
			return currentUserSession.toString();
			
		}
		else
			throw new LoginException("Invalid UserName or Password!");
			
			
	}

	@Override
	public String logOutAdmin(String key) throws LoginException {
		
		CurrentUserSession cus=	currentUserSessionDao.findByUuid(key).orElseThrow(()-> new LoginException("Enter correct Key"));

		adminLoginDTODao.deleteById(cus.getUserId());
		currentUserSessionDao.delete(cus);	
		return "Logout Successful";
	}

	
}
