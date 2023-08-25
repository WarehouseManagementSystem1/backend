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
	private String phoneNumber;
	
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public UserType getUser() {
		return user;
	}


	public void setUser(UserType user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public Warehouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", user=" + user
				+ ", password=" + password + ", owner=" + owner + ", warehouse=" + warehouse + ", getId()=" + getId()
				+ "]";
	}


	public User(Long id, String name, String email, String phoneNumber, UserType user, String password, Owner owner,
			Warehouse warehouse) {
		super(id);
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.user = user;
		this.password = password;
		this.owner = owner;
		this.warehouse = warehouse;
	}


	public User(Long id) {
		super(id);
		
	}


	public User() {
		super();
	}
	


	


	


	


	

	
}
