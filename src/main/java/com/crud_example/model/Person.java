package com.crud_example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String first_name;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String last_name;
	
	@Column(name = "phone_number", length = 50, nullable = false)
	private String phone_number;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "address", length = 50, nullable = false)
	private String address;
	
}
