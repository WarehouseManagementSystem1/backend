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

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Log extends BaseEntity {
	
	@Column(length = 20)
	private String transactionType;
	
	@Column
	private int warehouseId;

	@Column
	private String itemName;
	
	@Column
	private int itemId;
	
	@Column
	private int initialAreaId;
	
	@Column
	private int initialRackId;
	
	@Column
	private int initialLevelId;
	
	@Column
	private int initialBlockId;
	
	@Column
	private int finalAreaId;
	
	@Column
	private int finalRackId;
	
	@Column
	private int finalLevelId;
	
	@Column
	private int finalBlockId;

	public Log(Long id, String transactionType, int warehouseId, String itemName, int itemId, int initialAreaId,
			int initialRackId, int initialLevelId, int initialBlockId, int finalAreaId, int finalRackId,
			int finalLevelId, int finalBlockId) {
		super(id);
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

	
}




 







