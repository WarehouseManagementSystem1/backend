package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllItemDto {
	@JsonProperty("itemId")
	private long itemId;
	@JsonProperty("itemName")
	private String itemName;
	@JsonProperty("units")
	private int units;
	private Long blockId;
	@JsonProperty("blockNumber")
	private int blockNumber;
	private Long levelId;
	@JsonProperty("levelNumber")
	private int levelNumber;
	private Long rackId;
	@JsonProperty("rackNumber")
	private int rackNumber;
	private Long areaId;
	@JsonProperty("areaName")
	private String areaName;
	private Long warehouseId;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getBlockId() {
		return blockId;
	}
	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public Long getLevelId() {
		return levelId;
	}
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	public Long getRackId() {
		return rackId;
	}
	public void setRackId(Long rackId) {
		this.rackId = rackId;
	}
	public int getRackNumber() {
		return rackNumber;
	}
	public void setRackNumber(int rackNumber) {
		this.rackNumber = rackNumber;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	
	
	
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public AllItemDto(long itemId, String itemName, int units, Long blockId, int blockNumber, Long levelId,
			int levelNumber, Long rackId, int rackNumber, Long areaId, String areaName, Long warehouseId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.units = units;
		this.blockId = blockId;
		this.blockNumber = blockNumber;
		this.levelId = levelId;
		this.levelNumber = levelNumber;
		this.rackId = rackId;
		this.rackNumber = rackNumber;
		this.areaId = areaId;
		this.areaName = areaName;
		this.warehouseId = warehouseId;
	}
	public AllItemDto() {
		super();
	}
	
	
}
