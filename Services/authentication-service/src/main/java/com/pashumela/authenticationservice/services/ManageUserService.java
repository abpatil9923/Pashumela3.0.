package com.pashumela.authenticationservice.services;

import org.springframework.stereotype.Service;

import com.pashumela.authenticationservice.entities.User;

@Service
public interface ManageUserService {

	public User saveUserDetails(User user) throws Exception;
	
	public User getUserData(String mobileNumber) throws Exception;
	
}
