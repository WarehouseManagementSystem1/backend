package com.app.dto;

public class RackDto {

	private Long id;
	private int number;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public RackDto(Long id, int number) {
		super();
		this.id = id;
		this.number = number;
	}
	
	
}

