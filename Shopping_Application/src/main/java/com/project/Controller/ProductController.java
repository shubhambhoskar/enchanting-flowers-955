package com.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.AdminException;
import com.project.Exceptions.CategoryException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.ProductException;
import com.project.Service.ProductService;
import com.project.module.Category;
import com.project.module.Product;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// ***************************************************************************************************************
	@PostMapping("/product/{categoryId}")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product product,@PathVariable("categoryId") Integer categoryId,@RequestParam String key)throws ProductException, AdminException, LoginException{

		Product newProduct = productService.addProduct(product,categoryId,key);

		return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
	}

	// ***************************************************************************************************************
	@PutMapping("/product/{categoryId}")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product,@PathVariable("categoryId") Integer categoryId, @RequestParam String key)throws ProductException, AdminException, LoginException{

		Product newProduct = productService.addProduct(product,categoryId,key);

		return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
	}

	// ***************************************************************************************************************
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteproductHandler(@PathVariable("id") Integer id, @RequestParam String key)throws ProductException, AdminException, LoginException{

		Product deletedProduct = productService.deleteProduct(id,key);

		return new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
	}
	// ***************************************************************************************************************
	@GetMapping("/products/{category}")
	public ResponseEntity<List<Product>> viewProductbycategory(@PathVariable("category") String category) throws ProductException {

		List<Product> listOfproducts = productService.viewProductByCategory(category);

		return new ResponseEntity<List<Product>>(listOfproducts, HttpStatus.OK);
	}

	// ***************************************************************************************************************
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProduct() throws ProductException {

		List<Product> listOfproducts = productService.viewAllProduct();

		return new ResponseEntity<List<Product>>(listOfproducts, HttpStatus.OK);
	}
	// ***************************************************************************************************************
		@GetMapping("/product/{id}")
		public ResponseEntity<Product> viewProductById(@PathVariable("id") Integer id) throws ProductException {

			Product product = productService.viewProductByid(id);

			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
}
