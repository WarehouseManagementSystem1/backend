package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaDto {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("areaName")
	private String areaName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAreaname() {
		return areaName;
	}
	public void setAreaname(String areaname) {
		this.areaName = areaname;
	}
	public AreaDto(Long id, String areaname) {
		super();
		this.id = id;
		this.areaName = areaname;
	}
	public AreaDto() {
		super();
	}
	
}
