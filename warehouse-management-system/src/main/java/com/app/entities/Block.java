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
@NoArgsConstructor
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


	public Block() {
		super();
	}
	
	
}
