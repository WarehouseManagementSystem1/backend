package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table

@ToString
@Setter
@Getter
public class Log extends BaseEntity {
	
	@Column(length = 20)
	private String transactionType;
	
	@Column
	private Long warehouseId;

	@Column
	private String itemName;
	
	@Column
	private Long itemId;
	
	@Column
	private String initialAreaName;
	
	@Column
	private Integer initialRackNumber;
	
	@Column
	private Integer initialLevelNumber;
	
	@Column
	private Integer initialBlockNumber;
	
	@Column
	private String finalAreaName;
	
	@Column
	private Integer finalRackNumber;
	
	@Column
	private Integer finalLevelNumber;
	
	@Column
	private Integer finalBlockNumber;

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

	public Integer getInitialRackNumber() {
		return initialRackNumber;
	}

	public void setInitialRackNumber(Integer initialRackNumber) {
		this.initialRackNumber = initialRackNumber;
	}

	public Integer getInitialLevelNumber() {
		return initialLevelNumber;
	}

	public void setInitialLevelNumber(Integer initialLevelNumber) {
		this.initialLevelNumber = initialLevelNumber;
	}

	public Integer getInitialBlockNumber() {
		return initialBlockNumber;
	}

	public void setInitialBlockNumber(Integer initialBlockNumber) {
		this.initialBlockNumber = initialBlockNumber;
	}

	public String getFinalAreaName() {
		return finalAreaName;
	}

	public void setFinalAreaName(String finalAreaName) {
		this.finalAreaName = finalAreaName;
	}

	public Integer getFinalRackNumber() {
		return finalRackNumber;
	}

	public void setFinalRackNumber(Integer finalRackNumber) {
		this.finalRackNumber = finalRackNumber;
	}

	public Integer getFinalLevelNumber() {
		return finalLevelNumber;
	}

	public void setFinalLevelNumber(Integer finalLevelNumber) {
		this.finalLevelNumber = finalLevelNumber;
	}

	public Integer getFinalBlockNumber() {
		return finalBlockNumber;
	}

	public void setFinalBlockNumber(Integer finalBlockNumber) {
		this.finalBlockNumber = finalBlockNumber;
	}

	public Log( String transactionType, Long warehouseId, String itemName, Long itemId, String initialAreaName,
			Integer initialRackNumber, Integer initialLevelNumber, Integer initialBlockNumber, String finalAreaName,
			Integer finalRackNumber, Integer finalLevelNumber, Integer finalBlockNumber) {
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

	public Log() {
		super();
	}

	
}




 







