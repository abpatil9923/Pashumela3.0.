package com.pashumela.authenticationservice.entities;

public class OtpValidationRequest {

	private String userName;
	private String otpNumber;
	
	public OtpValidationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtpValidationRequest(String userName, String otpNumber) {
		super();
		this.userName = userName;
		this.otpNumber = otpNumber;
	}
	

	public String getOtpNumber() {
		return otpNumber;
	}

	public void setOtpNumber(String otpNumber) {
		this.otpNumber = otpNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
