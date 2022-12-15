package com.project.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	private Integer productId;
	
	private String productName;
	
	private Double price;
	
	private String color;
	
	private String dimensions;
	
	private String manufacturer;
	
	private Integer quantity;

	public ProductDto(Integer id, Integer productId, String productName, Double price, String color, String dimensions,
			String manufacturer, Integer quantity) {
		super();
		Id = id;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimensions = dimensions;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
	}
	
	

}
