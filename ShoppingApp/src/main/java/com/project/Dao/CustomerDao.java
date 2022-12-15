package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.module.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
