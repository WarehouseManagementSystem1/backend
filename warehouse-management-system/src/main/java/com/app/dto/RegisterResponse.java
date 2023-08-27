package com.app.dto;

public class RegisterResponse {
	
	private String message;
	private Long ownerid;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}
	public RegisterResponse(String message, Long ownerid) {
		super();
		this.message = message;
		this.ownerid = ownerid;
	}
	public RegisterResponse() {
		super();
	}
		
	
	
}
