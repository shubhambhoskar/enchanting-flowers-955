package com.project.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;
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
	
	//Add the dependency of Category
	@ManyToOne
	@JsonIgnore
	private Category category;  // One to many
	
	
}
