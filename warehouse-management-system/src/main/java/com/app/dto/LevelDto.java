package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelDto {
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("levelnumber")
	private int levelnumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getLevelnumber() {
		return levelnumber;
	}
	public void setLevelnumber(int levelnumber) {
		this.levelnumber = levelnumber;
	}
	public LevelDto(Long id, int levelnumber) {
		super();
		this.id = id;
		this.levelnumber = levelnumber;
	}
	public LevelDto() {
		super();
	}
	
}
