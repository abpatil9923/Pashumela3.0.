package com.pashumela.authenticationservice.services;

import org.springframework.stereotype.Service;

import com.pashumela.authenticationservice.entities.OtpResponse;
import com.pashumela.authenticationservice.entities.OtpValidationRequest;
import com.pashumela.authenticationservice.entities.User;

@Service
public interface SmsService {

	public OtpResponse sendSMS(User user);
	
	public String validateOtp(OtpValidationRequest otpValidationRequest);
}
