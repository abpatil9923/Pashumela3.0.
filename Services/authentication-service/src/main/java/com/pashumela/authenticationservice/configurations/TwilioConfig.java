package com.pashumela.authenticationservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {

	private String AccountSid;
	private String AuthToken;
	private String phoneNumber;
	
	public TwilioConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TwilioConfig(String accountSid, String authToken, String phoneNumber) {
		super();
		AccountSid = accountSid;
		AuthToken = authToken;
		this.phoneNumber = phoneNumber;
	}
	public String getAccountSid() {
		return AccountSid;
	}
	public void setAccountSid(String accountSid) {
		AccountSid = accountSid;
	}
	public String getAuthToken() {
		return AuthToken;
	}
	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
