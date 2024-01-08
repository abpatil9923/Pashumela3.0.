package com.pashumela.authenticationservice.entities;

public class OtpResponse {

	private OtpStatus status;
	private String message;
	
	public OtpResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpResponse(OtpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public OtpStatus getStatus() {
		return status;
	}
	public void setStatus(OtpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
