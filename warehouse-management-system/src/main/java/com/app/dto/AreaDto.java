package com.app.dto;

public class AreaDto {
	private Long id;
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
