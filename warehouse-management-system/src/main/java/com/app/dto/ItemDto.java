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

	public Long getBlockId() {
		return blockid;
	}


	public void setBlockId(Long blockId) {
		this.blockid = blockId;
	}


	public Long getLevelId() {
		return levelid;
	}


	public void setLevelId(Long levelId) {
		this.levelid = levelId;
	}


	public Long getRackId() {
		return rackid;
	}


	public void setRackId(Long rackId) {
		this.rackid = rackId;
	}


	public Long getAreaId() {
		return areaid;
	}


	public void setAreaId(Long areaId) {
		this.areaid = areaId;
	}


	public Long getWarehouseId() {
		return warehouseid;
	}


	public void setWarehouseId(Long warehouseId) {
		this.warehouseid = warehouseId;
	}


	private Long id;
	
	
	private Long blockid;
	

	private Long levelid;
	
	
	private Long rackid;
	
	
	private Long areaid;
	
	
	private Long warehouseid;
}
