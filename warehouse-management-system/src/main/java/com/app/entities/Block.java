package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@ToString

public class Block extends BaseEntity {
	
	@Column
	private int blockNumber;
	
	@Column
	private float blockLength;
	
	@Column
	private float blockWidth;
	
	@Column
	private OccupiedLevel occupiedStatus;
	
	
	//mapping between block and LEVEL
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Level_Id")
	private Level level;
	
	
	//mapping between block and RACK
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Rack_Id")
	private Rack rack;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Area_Id")
	private Area area;
	
	
	//mapping between block and WAREHOUSE
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Warehouse_Id")
	private Warehouse warehouse;

	
	//mapping between block and ITEM
	@OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> items = new ArrayList<Item>();


	


	public Block(Long id, int blockNumber, float blockLength, float blockWidth, OccupiedLevel occupiedStatus,
			Level level, Rack rack, Area area, Warehouse warehouse, List<Item> items) {
		super(id);
		this.blockNumber = blockNumber;
		this.blockLength = blockLength;
		this.blockWidth = blockWidth;
		this.occupiedStatus = occupiedStatus;
		this.level = level;
		this.rack = rack;
		this.area = area;
		this.warehouse = warehouse;
		this.items = items;
	}


	public Block(Long id) {
		super(id);
		
	}
	
	

	public int getBlockNumber() {
		return blockNumber;
	}


	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}


	public float getBlockLength() {
		return blockLength;
	}


	public void setBlockLength(float blockLength) {
		this.blockLength = blockLength;
	}


	public float getBlockWidth() {
		return blockWidth;
	}


	public void setBlockWidth(float blockWidth) {
		this.blockWidth = blockWidth;
	}


	public OccupiedLevel getOccupiedStatus() {
		return occupiedStatus;
	}


	public void setOccupiedStatus(OccupiedLevel occupiedStatus) {
		this.occupiedStatus = occupiedStatus;
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


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public Block() {
		super();
	}
	
	
}
