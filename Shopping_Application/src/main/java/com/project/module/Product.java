package com.project.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@NotNull(message = "Product name cannot be null")
	@NotBlank(message = "Product name cannot be blank...!")
	private String productName;
	
	@Min(value = 1,message = "Min price required is 1")
	private double price;
	
	@NotNull(message = "Product color cannot be null")
	@NotBlank(message = "Product color cannot be blank...!")
	private String color;
	
	@NotNull(message = "Product dimensions cannot be null")
	@NotBlank(message = "Product dimensions cannot be blank...!")
	private String dimensions;
	
	@NotNull(message = "Product manufacturer cannot be null")
	@NotBlank(message = "Product manufacturer cannot be blank...!")
	private String manufacturer;
	
	@Min(value = 1,message = "Min quantity required is 1")
	private int quantity;
	
	
	@NotNull(message = "Product category cannot be null")
	@NotBlank(message = "Product category cannot be blank...!")
	private String category;
	


	
}
