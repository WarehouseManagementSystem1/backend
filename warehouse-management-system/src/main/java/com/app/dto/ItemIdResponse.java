package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemIdResponse {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("units")
	private int units;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public ItemIdResponse(Long id, String name,int units) {
		super();
		this.id = id;
		this.name = name;
		this.units=units;
	}

	@Override
	public String toString() {
		return "ItemIdResponse [id=" + id + ", name=" + name + ", units=" + units + "]";
	}
		
	
}
