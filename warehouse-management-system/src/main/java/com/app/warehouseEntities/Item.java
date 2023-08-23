package com.app.warehouseEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Item extends BaseEntity {
	
	@Column
	private int units;
	
	@Column
	private float unitLength;
	
	@Column
	private float unitWidth;
	
	@Column
	private float unitHeight;
	
	@Column
	@Enumerated
	private Stacking stackingAllowed;
	
	@Column
	@Enumerated
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "Block_Id")
	private Block block;
	
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
	
	

}
