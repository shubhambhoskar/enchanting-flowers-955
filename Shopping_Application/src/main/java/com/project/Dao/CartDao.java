package com.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Cart;
import com.project.module.Customer;

public interface CartDao extends JpaRepository<Cart, Integer>{
	public List<Cart> findByCustomer(Customer customer);
}
