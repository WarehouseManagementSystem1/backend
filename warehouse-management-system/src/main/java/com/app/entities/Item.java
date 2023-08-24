package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Item extends BaseEntity {
	
	@Column
	private int units;
	
	@Column
	private float unitLength;
	
	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public float getUnitLength() {
		return unitLength;
	}

	public void setUnitLength(float unitLength) {
		this.unitLength = unitLength;
	}

	public float getUnitWidth() {
		return unitWidth;
	}

	public void setUnitWidth(float unitWidth) {
		this.unitWidth = unitWidth;
	}

	public float getUnitHeight() {
		return unitHeight;
	}

	public void setUnitHeight(float unitHeight) {
		this.unitHeight = unitHeight;
	}

	public Stacking getStackingAllowed() {
		return stackingAllowed;
	}

	public void setStackingAllowed(Stacking stackingAllowed) {
		this.stackingAllowed = stackingAllowed;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = Status.valueOf(status);
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Column
	private float unitWidth;
	
	@Column
	private float unitHeight;
	
	@Column
	@Enumerated
	private Stacking stackingAllowed;
	
	@Column
	@Enumerated
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "Block_Id")
	private Block block;
	
	@ManyToOne
	@JoinColumn(name = "Level_Id")
	private Level level;
	
	@ManyToOne
	@JoinColumn(name = "Rack_Id")
	private Rack rack;
	
	@ManyToOne
	@JoinColumn(name = "Area_Id")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "Warehouse_Id")
	private Warehouse warehouse;
	
	

}
