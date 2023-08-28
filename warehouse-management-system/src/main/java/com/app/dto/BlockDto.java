package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockDto {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("blockNumber")
	private int blockNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNunber(int blockNunber) {
		this.blockNumber = blockNunber;
	}
	public BlockDto(Long id, int blockNunber) {
		super();
		this.id = id;
		this.blockNumber = blockNunber;
	}
	public BlockDto() {
		
	}
	
	
}
