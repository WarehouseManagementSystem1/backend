package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WarehouseDto {
	@JsonProperty("warehousename")
	private String name;
	@JsonProperty("warehouseaddress")
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public WarehouseDto(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public WarehouseDto() {
		super();
	}
	
	
}
