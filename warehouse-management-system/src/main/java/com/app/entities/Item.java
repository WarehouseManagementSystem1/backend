package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private float itemLength;
	
	@Column
	private String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public float getItemLength() {
		return itemLength;
	}

	public void setItemLength(float itemLength) {
		this.itemLength = itemLength;
	}

	public float getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(float unitWidth) {
		this.itemWidth = unitWidth;
	}

	public float getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(float itemHeight) {
		this.itemHeight = itemHeight;
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
	private float itemWidth;
	
	@Column
	private float itemHeight;
	
	
	//mapping for item and BLOCK 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Block_Id")
	private Block block;
	
	
	//mapping for item and LEVEL 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Level_Id")
	private Level level;
	
	
	//mapping for item and RACK
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Rack_Id")
	private Rack rack;
	
	
	//mapping for item and AREA
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Area_Id")
	private Area area;
	
	
	//mapping for item and WAREHOUSE
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Warehouse_Id")
	private Warehouse warehouse;

	

	

	public Item(Long id, int units, float itemLength, String name, float itemWidth, float itemHeight, Block block,
			Level level, Rack rack, Area area, Warehouse warehouse) {
		super(id);
		this.units = units;
		this.itemLength = itemLength;
		this.name = name;
		this.itemWidth = itemWidth;
		this.itemHeight = itemHeight;
		this.block = block;
		this.level = level;
		this.rack = rack;
		this.area = area;
		this.warehouse = warehouse;
	}

	public Item(Long id) {
		super(id);
		
	}

	public Item() {
		super();
	}
	
	

}
