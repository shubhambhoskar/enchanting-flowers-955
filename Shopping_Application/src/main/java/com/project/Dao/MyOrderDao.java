package com.project.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Exceptions.OrderException;
import com.project.module.MyOrder;

@Repository
public interface MyOrderDao extends JpaRepository<MyOrder, Integer>{
	public List<MyOrder> findByOrderDate(LocalDate date) throws OrderException ;
	
//	@Query("select o from MyOrder o where o.Address.city= ?1")
//	public List<MyOrder> getOrderByCity(String city) throws OrderException;
	
	@Query("select o from MyOrder o where o.customer.CustomerLoginId= ?1")
	public List<MyOrder> getOrderByCID(Integer CID) throws OrderException;
	
}
