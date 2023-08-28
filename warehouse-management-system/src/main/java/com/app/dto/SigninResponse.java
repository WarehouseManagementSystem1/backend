package com.app.dto;

import com.app.entities.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;



public class SigninResponse {
	@JsonProperty("userId")
	private Long userId;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("userType")
	private UserType userType;
	@JsonProperty("warehouseId")
	private Long warehouseId;
	@JsonProperty("ownerid")
	private Long ownerId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public SigninResponse(Long userId, String firstname, String lastname, UserType userType, Long warehouseId,
			Long ownerId) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.userType = userType;
		this.warehouseId = warehouseId;
		this.ownerId = ownerId;
	}
	public SigninResponse() {
		super();
	}
	
	

}
