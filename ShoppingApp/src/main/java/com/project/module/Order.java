package com.project.module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToOne;

import com.project.Dto.AddressDto;
import com.project.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String OrderStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_order",joinColumns = @JoinColumn(name = "order_Id",referencedColumnName = "orderId"))
	private Customer customer;
	
	@ElementCollection
	@CollectionTable(name="order_productList",joinColumns = @JoinColumn(name = "order_Id",referencedColumnName = "orderId"))
	private List<ProductDto> productList = new ArrayList<>();

	@Embedded
	private AddressDto orderAddress;

	public Order(LocalDate orderDate, String orderStatus, Customer customer, List<ProductDto> productList,
			AddressDto orderAddress) {
		super();
		this.orderDate = orderDate;
		OrderStatus = orderStatus;
		this.customer = customer;
		this.productList = productList;
		this.orderAddress = orderAddress;
	}

	
	
	
	
}
