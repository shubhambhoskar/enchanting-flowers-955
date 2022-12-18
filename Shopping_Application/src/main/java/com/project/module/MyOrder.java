package com.project.module;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MyOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private LocalDate orderDate;
	private String OrderStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "order_table_product", joinColumns = @JoinColumn(name = "order_table_id"))
	@Column(name = "quantity")
	@MapKeyJoinColumn(name = "product_id", referencedColumnName = "productId")
	@JsonIgnore
	private Map<Product, Integer> products;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Address address;
}
