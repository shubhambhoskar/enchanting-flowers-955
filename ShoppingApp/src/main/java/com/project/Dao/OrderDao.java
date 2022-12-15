package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
