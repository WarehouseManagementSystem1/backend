package com.app.entities;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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

public class Warehouse extends BaseEntity {
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 100)
	private String address;
	
	//----------------------------------ye krna hai re bhai
	//private Owner ownerId;
	
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Area> areas = new ArrayList<Area>();
	
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Block> blocks = new ArrayList<Block>();
	
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Item> items = new ArrayList<Item>();
 	

}
