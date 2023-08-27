package com.app.dto;

public class BlockDto {
	private Long id;
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
