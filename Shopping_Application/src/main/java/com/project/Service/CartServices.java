package com.project.Service;

import java.util.List;

import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.ProductException;
import com.project.module.Cart;
import com.project.module.Product;

public interface CartServices {
	
	public Cart addProductToCart(Integer productId, int quantity, String key)throws ProductException,LoginException,CartException,CustomerException;
	
	public Cart updateProductQuantity(Integer productId, int quantity, String key)throws ProductException,LoginException,CartException, CustomerException;
	
	public List<Product> viewAllProducts(String key)throws ProductException,LoginException,CartException, CustomerException;
	
	public Cart removeProductFromCart(Integer productId, String key)throws ProductException,LoginException,CartException,CustomerException;
	
//	public Cart removeAllProducts(String key)throws ProductException,LoginException,CartException,CustomerException;
	
	
}
