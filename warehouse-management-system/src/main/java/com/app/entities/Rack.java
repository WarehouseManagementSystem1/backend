package com.app.entities;

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

public class Rack extends BaseEntity {
	
	@Column
	private int rackNumber;
	
	
	//mapping for rack and AREA
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Area_Id")
	private Area area;

	
	//mapping for rack and LEVEL
	@OneToMany(mappedBy = "rack", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Level> levels ; 
	
	
	//mapping for rack and BLOCK
	@OneToMany(mappedBy = "rack", cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Block> blocks ;
	
	
	//mapping for rack and ITEM
	@OneToMany(mappedBy = "rack", cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> items ;


	


	public int getRackNumber() {
		return rackNumber;
	}


	public void setRackNumber(int rackNumber) {
		this.rackNumber = rackNumber;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public List<Level> getLevels() {
		return levels;
	}


	public void setLevels(List<Level> levels) {
		this.levels = levels;
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


	public Rack(Long id, int rackNumber, Area area, List<Level> levels, List<Block> blocks, List<Item> items) {
		super(id);
		this.rackNumber = rackNumber;
		this.area = area;
		this.levels = levels;
		this.blocks = blocks;
		this.items = items;
	}


	public Rack(Long id) {
		super(id);
	}


	public Rack() {
		super();
	}
	
	
	
}
