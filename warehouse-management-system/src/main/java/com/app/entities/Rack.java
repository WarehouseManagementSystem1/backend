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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Area_Id")
	private Area area;

	@OneToMany(mappedBy = "rack", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Level> levels ; 
	
	@OneToMany(mappedBy = "rack", cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Block> blocks ;
	
	@OneToMany(mappedBy = "rack", cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> items ;
	
	
}
