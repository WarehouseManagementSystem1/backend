package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ItemDto {
	
	@JsonProperty("itemId")
	private Long id;
	
	@JsonProperty("blockNumber")
	private Long blockid;
	
	@JsonProperty("levelNumber")
	private Long levelid;
	
	@JsonProperty("rackNumber")
	private Long rackid;
	
	@JsonProperty("areaName")
	private Long areaid;
	
	@JsonProperty("warehouseid")
	private Long warehouseid;
	
	public ItemDto() {
		super();
	}

	public ItemDto(Long id, Long blockid, Long levelid, Long rackid, Long areaid, Long warehouseid) {
		super();
		this.id = id;
		this.blockid = blockid;
		this.levelid = levelid;
		this.rackid = rackid;
		this.areaid = areaid;
		this.warehouseid = warehouseid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBlockid() {
		return blockid;
	}

	public void setBlockid(Long blockid) {
		this.blockid = blockid;
	}

	public Long getLevelid() {
		return levelid;
	}

	public void setLevelid(Long levelid) {
		this.levelid = levelid;
	}

	public Long getRackid() {
		return rackid;
	}

	public void setRackid(Long rackid) {
		this.rackid = rackid;
	}

	public Long getAreaid() {
		return areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Long getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(Long warehouseid) {
		this.warehouseid = warehouseid;
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", blockid=" + blockid + ", levelid=" + levelid + ", rackid=" + rackid
				+ ", areaid=" + areaid + ", warehouseid=" + warehouseid + "]";
	}
	
	
}
