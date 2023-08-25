package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class User extends BaseEntity  {
	
	@Column(name = "User_Name", length = 30)
	private String name;
	
	@Column(name = "Email", length = 30)
	private String email;
	
	@Column(name = "Contact_Number")
	private int phoneNumber;
	
	@Column(name = "User_Type")
	@Enumerated
	private UserType user;
	
	@Column(name="password")
	private String password;
	
	
	//mapping for user to owner
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ownerId")
	private Owner owner;
	
	
	//mapping for user and warehouse
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "warehouseId")
	private Warehouse warehouse;

}
