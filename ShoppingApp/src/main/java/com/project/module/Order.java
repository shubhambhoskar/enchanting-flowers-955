package com.project.module;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalDate orderDate;
	private String OrderStatus;
	
	// Dependency of Customer (Check at the run time)
	// Add the relationship
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "Customer_order",joinColumns = @JoinColumn(name = "orderId"))
	private Customer customer;
	
	@ElementCollection
	@CollectionTable(name="product_order",joinColumns = @JoinColumn(name = "orderId"))
	private List<Product> product;
	
//	@ElementCollection
//	@Embedded
//	private Address address;
	@ElementCollection
	@Embedded
	private Set<Address> addresses=new HashSet<Address>();
}
