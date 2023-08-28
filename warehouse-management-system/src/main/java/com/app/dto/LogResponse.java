package com.app.dto;

import jakarta.persistence.Column;

public class LogResponse {
	
	private String transactionType;
	private Long warehouseId;
	private String itemName;
	private Long itemId;
	private Long initialAreaId;
	private Long initialRackId;
	private Long initialLevelId;
	private Long initialBlockId;
	private Long finalAreaId;
	private Long finalRackId;
	private Long finalLevelId;
	private Long finalBlockId;
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getInitialAreaId() {
		return initialAreaId;
	}
	public void setInitialAreaId(Long initialAreaId) {
		this.initialAreaId = initialAreaId;
	}
	public Long getInitialRackId() {
		return initialRackId;
	}
	public void setInitialRackId(Long initialRackId) {
		this.initialRackId = initialRackId;
	}
	public Long getInitialLevelId() {
		return initialLevelId;
	}
	public void setInitialLevelId(Long initialLevelId) {
		this.initialLevelId = initialLevelId;
	}
	public Long getInitialBlockId() {
		return initialBlockId;
	}
	public void setInitialBlockId(Long initialBlockId) {
		this.initialBlockId = initialBlockId;
	}
	public Long getFinalAreaId() {
		return finalAreaId;
	}
	public void setFinalAreaId(Long finalAreaId) {
		this.finalAreaId = finalAreaId;
	}
	public Long getFinalRackId() {
		return finalRackId;
	}
	public void setFinalRackId(Long finalRackId) {
		this.finalRackId = finalRackId;
	}
	public Long getFinalLevelId() {
		return finalLevelId;
	}
	public void setFinalLevelId(Long finalLevelId) {
		this.finalLevelId = finalLevelId;
	}
	public Long getFinalBlockId() {
		return finalBlockId;
	}
	public void setFinalBlockId(Long finalBlockId) {
		this.finalBlockId = finalBlockId;
	}
	public LogResponse(String transactionType, Long warehouseId, String itemName, Long itemId, Long initialAreaId,
			Long initialRackId, Long initialLevelId, Long initialBlockId, Long finalAreaId, Long finalRackId,
			Long finalLevelId, Long finalBlockId) {
		super();
		this.transactionType = transactionType;
		this.warehouseId = warehouseId;
		this.itemName = itemName;
		this.itemId = itemId;
		this.initialAreaId = initialAreaId;
		this.initialRackId = initialRackId;
		this.initialLevelId = initialLevelId;
		this.initialBlockId = initialBlockId;
		this.finalAreaId = finalAreaId;
		this.finalRackId = finalRackId;
		this.finalLevelId = finalLevelId;
		this.finalBlockId = finalBlockId;
	}
	public LogResponse() {
		super();
	}
	
	
}
