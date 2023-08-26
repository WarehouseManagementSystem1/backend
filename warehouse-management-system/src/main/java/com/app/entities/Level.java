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

public class Level extends BaseEntity{ 
	
	@Column
	private String levelNumber;
	
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


	public Level(Long id, String levelNumber, float levelHeight, Rack rack, List<Block> levels, List<Item> items) {
		super(id);
		this.levelNumber = levelNumber;
		this.levelHeight = levelHeight;
		this.rack = rack;
		this.levels = levels;
		this.items = items;
	}


	public Level(Long id) {
		super(id);
		
	}


	public Level() {
		super();
	}
	

}
