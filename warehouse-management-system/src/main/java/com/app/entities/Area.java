package com.app.entities;

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
@Table

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Area extends BaseEntity {

	@Column(nullable = false)
	private String areaName;
	
	@ManyToOne
	@JoinColumn(name = "warehouse_Id")
	private Warehouse warehouse;
	
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Rack> racks = new ArrayList<Rack>();
	
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Block> blocks = new ArrayList<Block>();

	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Item> items = new ArrayList<Item>();

}
