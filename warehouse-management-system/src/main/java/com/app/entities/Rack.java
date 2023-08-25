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

public class Rack extends BaseEntity {
	
	@Column
	private String rackNumber;
	
	
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
	
	
}
