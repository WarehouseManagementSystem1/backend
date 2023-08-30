package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogResponse {
	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("warehouseId")
	private Long warehouseId;
	@JsonProperty("itemName")
	private String itemName;
	@JsonProperty("itemId")
	private Long itemId;
	@JsonProperty("initialAreaName")
	private String initialAreaName;
	@JsonProperty("initialRackNumber")
	private Long initialRackNumber;
	@JsonProperty("initialLevelNumber")
	private Long initialLevelNumber;
	@JsonProperty("initialBlockNumber")
	private Long initialBlockNumber;
	@JsonProperty("finalAreaName")
	private String finalAreaName;
	@JsonProperty("finalRackNumber")
	private Long finalRackNumber;
	@JsonProperty("finalLevelNumber")
	private Long finalLevelNumber;
	@JsonProperty("finalBlockNumber")
	private Long finalBlockNumber;
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
	public String getInitialAreaName() {
		return initialAreaName;
	}
	public void setInitialAreaName(String initialAreaName) {
		this.initialAreaName = initialAreaName;
	}
	public Long getInitialRackNumber() {
		return initialRackNumber;
	}
	public void setInitialRackNumber(Long initialRackNumber) {
		this.initialRackNumber = initialRackNumber;
	}
	public Long getInitialLevelNumber() {
		return initialLevelNumber;
	}
	public void setInitialLevelNumber(Long initialLevelNumber) {
		this.initialLevelNumber = initialLevelNumber;
	}
	public Long getInitialBlockNumber() {
		return initialBlockNumber;
	}
	public void setInitialBlockNumber(Long initialBlockNumber) {
		this.initialBlockNumber = initialBlockNumber;
	}
	public String getFinalAreaName() {
		return finalAreaName;
	}
	public void setFinalAreaName(String finalAreaName) {
		this.finalAreaName = finalAreaName;
	}
	public Long getFinalRackNumber() {
		return finalRackNumber;
	}
	public void setFinalRackNumber(Long finalRackNumber) {
		this.finalRackNumber = finalRackNumber;
	}
	public Long getFinalLevelNumber() {
		return finalLevelNumber;
	}
	public void setFinalLevelNumber(Long finalLevelNumber) {
		this.finalLevelNumber = finalLevelNumber;
	}
	public Long getFinalBlockNumber() {
		return finalBlockNumber;
	}
	public void setFinalBlockNumber(Long finalBlockNumber) {
		this.finalBlockNumber = finalBlockNumber;
	}
	public LogResponse(String transactionType, Long warehouseId, String itemName, Long itemId, String initialAreaName,
			Long initialRackNumber, Long initialLevelNumber, Long initialBlockNumber, String finalAreaName,
			Long finalRackNumber, Long finalLevelNumber, Long finalBlockNumber) {
		super();
		this.transactionType = transactionType;
		this.warehouseId = warehouseId;
		this.itemName = itemName;
		this.itemId = itemId;
		this.initialAreaName = initialAreaName;
		this.initialRackNumber = initialRackNumber;
		this.initialLevelNumber = initialLevelNumber;
		this.initialBlockNumber = initialBlockNumber;
		this.finalAreaName = finalAreaName;
		this.finalRackNumber = finalRackNumber;
		this.finalLevelNumber = finalLevelNumber;
		this.finalBlockNumber = finalBlockNumber;
	}
	public LogResponse() {
		super();
		
	}
	
	
}
