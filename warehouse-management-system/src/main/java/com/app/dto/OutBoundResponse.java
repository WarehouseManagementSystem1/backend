package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutBoundResponse {
	@JsonProperty("areaName")
	private String areaName;
	@JsonProperty("rackNumber")
	private int rackNumber;
	@JsonProperty("levelNumber")
	private int levelNumber;
	@JsonProperty("blockNumber")
	private int blockNumber;
	
	
	
	public String getAreaName() {
		return areaName;
	}



	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}



	public int getRackNumber() {
		return rackNumber;
	}



	public void setRackNumber(int rackNumber) {
		this.rackNumber = rackNumber;
	}



	public int getLevelNumber() {
		return levelNumber;
	}



	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}



	public int getBlockNumber() {
		return blockNumber;
	}



	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}


	

	public OutBoundResponse(String areaName, int rackNumber, int levelNumber, int blockNumber) {
		super();
		this.areaName = areaName;
		this.rackNumber = rackNumber;
		this.levelNumber = levelNumber;
		this.blockNumber = blockNumber;
	}



	public OutBoundResponse() {
		super();
		
	}
	
	
}
