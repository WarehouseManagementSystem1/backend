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
	private Long initialAreaId;
	
	@Column
	private Long initialRackId;
	
	@Column
	private Long initialLevelId;
	
	@Column
	private Long initialBlockId;
	
	@Column
	private Long finalAreaId;
	
	@Column
	private Long finalRackId;
	
	@Column
	private Long finalLevelId;
	
	@Column
	private Long finalBlockId;

	

	public Log(String transactionType, Long warehouseId, String itemName, Long itemId, Long initialAreaId,
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



	public Log(Long id) {
		super(id);
		
	}



	public Log() {
		super();
		
	}



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

	

	
}




 







