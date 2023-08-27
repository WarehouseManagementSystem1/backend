package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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



	private Long id;
	
	@JsonProperty("blockid")
	private Long blockid;
	
	@JsonProperty("levelid")
	private Long levelid;
	
	@JsonProperty("rackid")
	private Long rackid;
	
	@JsonProperty("areaid")
	private Long areaid;
	
	@JsonProperty("warehouseid")
	private Long warehouseid;
}
