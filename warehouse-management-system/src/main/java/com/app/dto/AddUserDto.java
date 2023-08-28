package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AddUserDto {
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@JsonProperty("password")
	private String password;
	@JsonProperty("userType")
	private String userType;
	@JsonProperty("ownerId")
	private Long ownerId;
	@JsonProperty("warehouseId")
	private Long warehouseId;
	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	public AddUserDto() {
		super();
		
	}
	public AddUserDto(String firstname, String lastname, String email, String phoneNumber, String password,
			String userType, Long ownerId, Long warehouseId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userType = userType;
		this.ownerId = ownerId;
		this.warehouseId = warehouseId;
	}
	@Override
	public String toString() {
		return "AddUserDto [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", userType=" + userType + ", ownerId=" + ownerId
				+ ", warehouseId=" + warehouseId + "]";
	}
	
	
	
	
}
