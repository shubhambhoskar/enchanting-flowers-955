package com.project.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private LocalDate orderDate;
	private String OrderStatus;
	
	// Dependency of Customer (Check at the run time)
	// Add the relationship
	
	private Customer customer;
	
	// here add the produstList
	private List<Product> product;
	private Address address;
	
}
