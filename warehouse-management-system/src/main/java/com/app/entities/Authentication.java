package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Authentication extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private int userId;
	
	@Column(length = 30, nullable = false, unique = true)
	private String emailId;
	
	@Column(nullable = false)
	private String password;

}
