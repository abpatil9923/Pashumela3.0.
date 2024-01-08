package com.pashumela.authenticationservice.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pashumela.authenticationservice.constants.UserConstants;
import com.pashumela.authenticationservice.entities.OtpResponse;
import com.pashumela.authenticationservice.entities.OtpValidationRequest;
import com.pashumela.authenticationservice.entities.User;
import com.pashumela.authenticationservice.exceptions.UserNotFoundException;
import com.pashumela.authenticationservice.services.ManageUserService;
import com.pashumela.authenticationservice.services.SmsService;

import jakarta.validation.Valid;


@RestController
public class ManageUserController {
	
	@Autowired
	private ManageUserService userService;
	
	@Autowired
	private SmsService smsService;
	
	@PostMapping("/save-user")
	public ResponseEntity<HashMap<String, String>> saveNewUser(@Valid @RequestBody User user){
		HashMap<String, String> response = new HashMap<String, String>();
		try {
			User result = this.userService.getUserData(user.getMobileNumber());
			if(result != null) {
				response.put("message","mobile number :" +result.getMobileNumber() +" is already registered");	
			}
			else {
				this.userService.saveUserDetails(user);
				response.put("message","user successfully registered");
			}
			return ResponseEntity.ok(response) ;
		} catch (Exception e) {
			response.put("message", e.getMessage());
			return ResponseEntity.ok(response);
		}
	}
	
	@GetMapping("/get-user-details")
	public EntityModel<User> getUserDetails(@RequestParam String mobileNumber)throws Exception{

			User result = this.userService.getUserData(mobileNumber);
			if(result == null) {
				throw new UserNotFoundException("No user details are found with mobile number : " + mobileNumber);
			}

			EntityModel<User> entityModel = EntityModel.of(result);
			
			return entityModel;
	}
	
	@PostMapping("/login-user")
	public EntityModel<OtpResponse> loginUser(@RequestParam String mobileNumber)throws Exception{

			String mobileNum = UserConstants.MOBILE_NUMBER_PRIFIX+mobileNumber;
			User result = this.userService.getUserData(mobileNum);
			if(result == null) {
				throw new UserNotFoundException("No user details are found with mobile number : " + mobileNum);
			}
			
			User user = new User();
			user.setFirstName(result.getFirstName());
			user.setLastName(result.getLastName());
			user.setMobileNumber(result.getMobileNumber());
			OtpResponse resp = this.smsService.sendSMS(user);

			EntityModel<OtpResponse> entityModel = EntityModel.of(resp);
			return entityModel;
	}
	
	@GetMapping("/send-otp")
	public OtpResponse sendOtp() {
		User user = new User();
		user.setFirstName("Atul");
		user.setLastName("Patil");
		
		user.setMobileNumber("+919881580895");
		return this.smsService.sendSMS(user);
	}
	
	@PostMapping("/validate-otp")
    public String validateOtp(@RequestBody OtpValidationRequest otpValidationRequest) {
		return smsService.validateOtp(otpValidationRequest);
    }
	
}
