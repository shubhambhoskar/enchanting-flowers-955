package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.ProductException;
import com.project.Service.CartServices;
import com.project.module.Cart;
import com.project.module.Product;

@RestController
public class CartController {
	@Autowired
	private CartServices cartServices;
	
	@PostMapping("/carts")
	public ResponseEntity<Cart> addProductToCartHandler(@RequestParam Integer productId,@RequestParam Integer q,@RequestParam String key) throws ProductException, LoginException, CartException, CustomerException{

		Cart savedCart = cartServices.addProductToCart(productId, q, key);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}
	
	@PutMapping("/carts")
	public ResponseEntity<Cart> updateProductQuantityHandler(@RequestParam Integer productId,@RequestParam Integer q,@RequestParam String key) throws ProductException, LoginException, CartException, CustomerException{

		Cart savedCart = cartServices.updateProductQuantity(productId, q, key);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}
	
	@GetMapping("/carts")
	public ResponseEntity<List<Product>> getAllProductInCartHandler(@RequestParam String key) throws ProductException, LoginException, CartException, CustomerException{

		List<Product> products = cartServices.viewAllProducts(key);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}
	
	@DeleteMapping("/carts")
	public ResponseEntity<Cart> removeProductFromCartHandler(@RequestParam Integer productId,@RequestParam String key) throws ProductException, LoginException, CartException, CustomerException{

		Cart savedCart = cartServices.removeProductFromCart(productId, key);

		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);

	}
	
//	@PutMapping("/carts")
//	public ResponseEntity<Cart> removeAllProductsHandler(@RequestParam String key) throws ProductException, LoginException, CartException, CustomerException{
//
//		Cart savedCart = cartServices.removeAllProducts(key);
//
//		return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);
//
//	}
}
