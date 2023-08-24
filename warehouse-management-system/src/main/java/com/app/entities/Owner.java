package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

public class Owner extends BaseEntity {
	
	@Column(name = "User_Name", length = 30)
	private String name;
	
	@Column(name = "Email", length = 30)
	private String email;
	
	@Column(name = "Contact_Number")
	private int phoneNumber;
	
	//Mapping has to be done here
	@Column(name = "Warehouse_Id")
	private int wareHouseID;

}
