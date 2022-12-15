package com.project.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Address {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	
}
