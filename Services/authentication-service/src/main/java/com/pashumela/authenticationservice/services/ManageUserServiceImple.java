package com.pashumela.authenticationservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pashumela.authenticationservice.entities.User;
import com.pashumela.authenticationservice.repositories.ManageUserRepository;

@Service
public class ManageUserServiceImple implements ManageUserService{
	
	private Logger logger = LoggerFactory.getLogger(ManageUserServiceImple.class);

	@Autowired
	ManageUserRepository userRepository;
	
	@Override
	public User saveUserDetails(User user) throws Exception {
		logger.info("Entered into saveUserDetails of ManageUserServiceImple");
		if(user != null) {
			return this.userRepository.save(user);
		}else {
			logger.info("user details is not present");
			return null;
		}
	}

	@Override
	public User getUserData(String mobileNumber) throws Exception {
		User user = new User();
		if(mobileNumber != null) {
			user = this.userRepository.findUserByMobileNumber(mobileNumber);
		}else {
			logger.info("mobileNumber details is not present");
			throw new Exception("mobileNumber details is not present");
		}
		return user;
	}
}
