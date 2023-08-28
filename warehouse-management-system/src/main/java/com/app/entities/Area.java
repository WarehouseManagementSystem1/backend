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

public class Area extends BaseEntity {

	@Column(nullable = false)
	private String areaName;
	
	
	//mapping between area and WAREHOUSE 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "warehouse_Id")
	private Warehouse warehouse;
	
	
	//mapping between area and RACK
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Rack> racks;
	
	
	//mapping between area and BLOCK
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Block> blocks ;

	
	//mapping between area and ITEM
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> items ;


	public Area(Long id, String areaName, Warehouse warehouse, List<Rack> racks, List<Block> blocks, List<Item> items) {
		super(id);
		this.areaName = areaName;
		this.warehouse = warehouse;
		this.racks = racks;
		this.blocks = blocks;
		this.items = items;
	}





	public Area(Long id) {
		super(id);
		
	}



	public String getAreaName() {
		return areaName;
	}





	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}





	public Warehouse getWarehouse() {
		return warehouse;
	}





	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}





	public List<Rack> getRacks() {
		return racks;
	}





	public void setRacks(List<Rack> racks) {
		this.racks = racks;
	}





	public List<Block> getBlocks() {
		return blocks;
	}





	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}





	public List<Item> getItems() {
		return items;
	}





	public void setItems(List<Item> items) {
		this.items = items;
	}





	public Area() {
		super();
	}
	
	
	

}
