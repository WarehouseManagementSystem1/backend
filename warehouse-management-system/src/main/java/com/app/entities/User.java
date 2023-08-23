package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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

public class User extends BaseEntity  {
	
	@Column(name = "User_Id")
	private int userId;
	
	@Column(name = "User_Name", length = 30)
	private String name;
	
	@Column(name = "Email", length = 30)
	private String email;
	
	@Column(name = "Contact_Number")
	private int phoneNumber;
	
	@Column(name = "User_Type")
	@Enumerated
	private UserType user;
	
	//Mapping has to be done here
	@Column
	private int wareHouseID;

}
