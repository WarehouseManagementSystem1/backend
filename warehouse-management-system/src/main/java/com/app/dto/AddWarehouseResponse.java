package com.app.dto;

public class AddWarehouseResponse {
	private String message;
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
