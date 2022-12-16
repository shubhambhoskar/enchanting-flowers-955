package com.project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.module.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	public List<Product> findByCategory(String Category);
}
