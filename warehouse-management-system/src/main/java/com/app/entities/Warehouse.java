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

public class Warehouse extends BaseEntity {
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 100)
	private String address;
	
	
	//mapping for OWNER and warehouse
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ownerId")
	private Owner owner;
	
	
	//mapping for AREA and warehouse
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
	private List<Area> areas;
	
	
	//mapping for BLOCK and warehouse
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Block> blocks ;
	
	
	//mapping for ITEM and warehouse
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> items ;
	
	
	//mapping for USER and warehouse
	@OneToMany( mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
	private List<User> user;


	public Warehouse(Long id, String name, String address, Owner owner, List<Area> areas, List<Block> blocks,
			List<Item> items, List<User> user) {
		super(id);
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.areas = areas;
		this.blocks = blocks;
		this.items = items;
		this.user = user;
	}


	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Owner getOwner() {
		return owner;
	}




	public void setOwner(Owner owner) {
		this.owner = owner;
	}




	public List<Area> getAreas() {
		return areas;
	}




	public void setAreas(List<Area> areas) {
		this.areas = areas;
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




	public List<User> getUser() {
		return user;
	}




	public void setUser(List<User> user) {
		this.user = user;
	}




	public Warehouse(Long id) {
		super(id);
		
	}


	public Warehouse() {
		super();
	}
 	

}
