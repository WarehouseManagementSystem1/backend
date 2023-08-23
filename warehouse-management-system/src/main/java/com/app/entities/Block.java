package com.app.entities;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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

public class Block extends BaseEntity {
	
	@Column
	private String blockNumber;
	
	@Column
	private float blockLength;
	
	@Column
	private float blockWidth;
	
	@Column
	private float occupiedLength;
	
	@Column
	private float occupiedWidth;
	
	@Column
	@Enumerated
	private OccupiedLevel occupiedLevel;;
	
	
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

	@OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Item> items = new ArrayList<Item>();
}
