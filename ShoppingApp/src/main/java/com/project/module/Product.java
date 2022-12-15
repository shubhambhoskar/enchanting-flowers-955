package com.project.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Product {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;
	private String productName;
	private double price;
	private String color;
	private String dimensions;
	private String manufacturer;
	private int quantity;
	
	//Add the dependency of Category
	//@OneToMany
	private Category category;  // One to many
	
	
}
