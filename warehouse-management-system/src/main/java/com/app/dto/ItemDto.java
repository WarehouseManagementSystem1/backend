package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getUnits() {
		return units;
	}


	public void setUnits(int units) {
		this.units = units;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getBlockId() {
		return blockId;
	}


	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}


	public Long getLevelId() {
		return levelId;
	}


	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}


	public Long getRackId() {
		return rackId;
	}


	public void setRackId(Long rackId) {
		this.rackId = rackId;
	}


	public Long getAreaId() {
		return areaId;
	}


	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}


	public Long getWarehouseId() {
		return warehouseId;
	}


	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}


	private Long id;
	
	private int units;
	
	private String status;
	

	private Long blockId;
	

	private Long levelId;
	
	
	private Long rackId;
	
	
	private Long areaId;
	
	
	private Long warehouseId;
}
