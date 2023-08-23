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
@Table(name = "")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Rack extends BaseEntity {
	
	@Column
	private String rackNumber;
	
	@ManyToOne
	@JoinColumn(name = "Area_Id")
	private Area area;

	@OneToMany(mappedBy = "rack", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Level> levels = new ArrayList<Level>(); 
	
	@OneToMany(mappedBy = "rack", cascade =CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Block> blocks = new ArrayList<Block>();
	
	@OneToMany(mappedBy = "rack", cascade =CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Item> items = new ArrayList<Item>();
	
	
}
