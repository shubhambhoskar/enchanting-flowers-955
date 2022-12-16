package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
