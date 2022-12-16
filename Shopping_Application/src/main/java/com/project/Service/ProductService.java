package com.project.Service;

import java.util.List;

import com.project.Exceptions.AdminException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.ProductException;
import com.project.module.Product;

public interface ProductService {
	public Product addProduct(Product product,Integer id, String key) throws ProductException,AdminException, LoginException;

	public Product updateProduct(Product product,Integer id, String key) throws ProductException,AdminException, LoginException;

	public Product deleteProduct(Integer productId,String key) throws ProductException,AdminException, LoginException;
	
	public Product viewProductByid(Integer productId) throws ProductException;
	
	public List<Product> viewProductByCategory(String category) throws ProductException;

	public List<Product> viewAllProduct() throws ProductException;
}
