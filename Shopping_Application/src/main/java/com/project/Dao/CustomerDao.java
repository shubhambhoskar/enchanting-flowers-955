package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	public Customer findByUserName(String userName);
}
