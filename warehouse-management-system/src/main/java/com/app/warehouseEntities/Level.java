package com.app.warehouseEntities;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Level extends BaseEntity{ 
	
	@Column
	private String levelNumber;
	
	@Column
	private float levelHeight;
	
	@ManyToOne
	@JoinColumn(name = "Rack_Id")
	private Rack rack;
	
	
	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Block> levels = new ArrayList<Block>();
	
	@OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Item> items = new ArrayList<Item>();

}
