package com.pashumela.authenticationservice.services;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pashumela.authenticationservice.configurations.TwilioConfig;
import com.pashumela.authenticationservice.entities.OtpResponse;
import com.pashumela.authenticationservice.entities.OtpStatus;
import com.pashumela.authenticationservice.entities.OtpValidationRequest;
import com.pashumela.authenticationservice.entities.User;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServiceImpl implements SmsService{

	@Autowired 
	private TwilioConfig twilioConfig;
    Map<String, String> otpMap = new HashMap<>();
	
	public OtpResponse sendSMS(User user) {
		OtpResponse otpResponse = null;
		try {
			PhoneNumber to = new PhoneNumber(user.getMobileNumber());//to
			PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
			String otp = generateOTP();
			String otpMessage = "Dear Customer , Your OTP is  " + otp + " for sending sms through Spring boot application. Thank You.";
			Message message = Message
			        .creator(to, from,
			                otpMessage)
			        .create();
			otpMap.put(user.getFirstName(), otp);
			otpResponse = new OtpResponse(OtpStatus.DELIVERED, otpMessage);
		} catch (Exception e) {
			e.printStackTrace();
			otpResponse = new OtpResponse(OtpStatus.FAILED, e.getMessage());
		}
		return otpResponse;
	}

	@Override
	public String validateOtp(OtpValidationRequest otpValidationRequest) {
		Set<String> keys = otpMap.keySet();
		String username = null;
		for(String key : keys)
			username = key;
        if (otpValidationRequest.getUserName().equals(username)) {
            otpMap.remove(username,otpValidationRequest.getOtpNumber());
            return "OTP is valid!";
        } else {
            return "OTP is invalid!";
        }
	}
	
	private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }

}
