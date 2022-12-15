package com.project.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AddressDto {

	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private  String country;
	private Integer pincode;
	public AddressDto(String streetNo, String buildingName, String city, String state, String country,
			Integer pincode) {
		super();
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
	
}
