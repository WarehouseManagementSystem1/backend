package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InboundResponse {
	
	@JsonProperty("itemId")
	private Long itemId;
	@JsonProperty("areaId")
	private Long areaId;
	@JsonProperty("rackId")
	private Long rackId;
	@JsonProperty("LevelId")
	private Long LevelId;
	@JsonProperty("blockId")
	private Long blockId;
	
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public Long getRackId() {
		return rackId;
	}
	public void setRackId(Long rackId) {
		this.rackId = rackId;
	}
	public Long getLevelId() {
		return LevelId;
	}
	public void setLevelId(Long levelId) {
		LevelId = levelId;
	}
	public Long getBlockId() {
		return blockId;
	}
	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}
	
	public InboundResponse(Long itemId, Long areaId, Long rackId, Long levelId, Long blockId) {
		super();
		this.itemId = itemId;
		this.areaId = areaId;
		this.rackId = rackId;
		LevelId = levelId;
		this.blockId = blockId;
	}
	public InboundResponse() {
		super();
	}
	
	
}
