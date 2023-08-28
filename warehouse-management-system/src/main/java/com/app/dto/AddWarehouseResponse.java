package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddWarehouseResponse {
	@JsonProperty("message")
	private String message;
	@JsonProperty("warehouseid")
	private Long warehouseid;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}
	public AddWarehouseResponse(String message, Long warehouseid) {
		super();
		this.message = message;
		this.warehouseid = warehouseid;
	}
	public AddWarehouseResponse() {
		super();
	}
	
	

}
