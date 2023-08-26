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
@NoArgsConstructor
@ToString

public class Level extends BaseEntity{ 
	
	@Column
	private int levelNumber;
	
	@Column
	private float levelHeight;
	
	
	//mapping for level and RACK
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Rack_Id")
	private Rack rack;
	
	
	//mapping for level and BLOCK
	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Block> levels ;
	
	
	//mapping for level and ITEM
	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> items ;


	


	


	public int getLevelNumber() {
		return levelNumber;
	}



	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}



	public float getLevelHeight() {
		return levelHeight;
	}



	public void setLevelHeight(float levelHeight) {
		this.levelHeight = levelHeight;
	}



	public Rack getRack() {
		return rack;
	}



	public void setRack(Rack rack) {
		this.rack = rack;
	}



	public List<Block> getLevels() {
		return levels;
	}



	public void setLevels(List<Block> levels) {
		this.levels = levels;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public Level(Long id) {
		super(id);
		
	}

	

	public Level(Long id, int levelNumber, float levelHeight, Rack rack, List<Block> levels, List<Item> items) {
		super(id);
		this.levelNumber = levelNumber;
		this.levelHeight = levelHeight;
		this.rack = rack;
		this.levels = levels;
		this.items = items;
	}


	public Level() {
		super();
	}
	

}
