package com.app.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@ToString

public class Owner extends BaseEntity {
	
	@Column(name = "User_Name", length = 30)
	private String name;
	
	@Column(name = "Email", length = 30)
	private String email;
	
	@Column(name = "Contact_Number")
	private int phoneNumber;
	

	//mapping for Owner and LIST
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
	private List<Warehouse> warehouse;
	
	
	//mapping for owner and USER
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER )
	private List<User> user;


	public Owner(Long id ) {
		super(id);
		
	}


	public Owner(String name, String email, int phoneNumber, List<Warehouse> warehouse, List<User> user) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.warehouse = warehouse;
		this.user = user;
	}


	public Owner() {
		super();
	}
	

}
