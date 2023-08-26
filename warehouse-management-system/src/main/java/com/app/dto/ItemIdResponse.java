package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemIdResponse {
	private Long id;
	private String name;
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
