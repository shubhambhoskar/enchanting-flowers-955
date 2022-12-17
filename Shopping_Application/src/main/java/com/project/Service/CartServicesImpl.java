package com.project.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CartDao;
import com.project.Dao.CategoryDao;
import com.project.Dao.CurrentUserSessionDao;
import com.project.Dao.CustomerDao;
import com.project.Dao.ProductDao;
import com.project.Dto.ProductDto;
import com.project.Exceptions.AdminException;
import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.ProductException;
import com.project.module.Cart;
import com.project.module.CurrentUserSession;
import com.project.module.Customer;
import com.project.module.Product;

@Service
public class CartServicesImpl implements CartServices{
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CurrentUserSessionDao csdao;
	
	@Autowired
	private CartDao cartdao;
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Cart addProductToCart(Integer productId, int quantity, String key) throws ProductException, LoginException, CartException,CustomerException {
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Product> existingProduct = productDao.findById(productId);

		if (existingProduct.isPresent() == false)
			throw new ProductException("Invalid Product id");

		Product product = existingProduct.get();

		Optional<Customer> existingUser = customerDao.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			Cart cart = customer.getCart();
			
			Map<Product, Integer> map = cart.getProducts();
			if(product.getQuantity()>quantity) {
				map.put(product, quantity);
			}else {
				throw new CartException("Product is not avilable in this many quantity..");
			}
				
			Cart savedCart = cartdao.save(cart);

			return savedCart;

		} else {
			throw new CustomerException("User Not Found");
		}

	}

	@Override
	public Cart updateProductQuantity(Integer productId, int quantity, String key)throws ProductException, LoginException, CartException, CustomerException {
		
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Product> existingProduct = productDao.findById(productId);

		if (existingProduct.isPresent() == false)
			throw new ProductException("Invalid Product id");

		Product product = existingProduct.get();

		Optional<Customer> existingUser = customerDao.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			Cart cart = customer.getCart();
			
			Map<Product, Integer> map = cart.getProducts();
			if(product.getQuantity()>quantity) {
				map.put(product, quantity);
			}else {
				throw new CartException("Product is not avilable in this many quantity..");
			}
				
			Cart savedCart = cartdao.save(cart);

			return savedCart;

		} else {
			throw new CustomerException("User Not Found");
		}
	}

	@Override
	public List<Product> viewAllProducts(String key) throws ProductException, LoginException, CartException, CustomerException {
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Customer> existingUser = customerDao.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			Cart cart = customer.getCart();
			Map<Product, Integer> map = cart.getProducts();

			if (map.size() > 0) {
				List<Product> pro = new ArrayList<>();
				for (Product name : map.keySet()) {
					pro.add(name);
				}

				return pro;

			} else {
				throw new ProductException("Product Not found in Cart");
			}

		} else {
			throw new CustomerException("User Not Found");
		}
	}
	
	@Override
	public Cart removeProductFromCart(Integer productId, String key)throws ProductException, LoginException, CartException ,CustomerException{
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == true) {
			throw new CustomerException("Only Customer can make changes");
		}

		Optional<Product> existingProduct = productDao.findById(productId);

		if (existingProduct.isPresent() == false)
			throw new ProductException("Invalid Product id");

		Product product = existingProduct.get();

		Optional<Customer> existingUser = customerDao.findById(loggedInUser.getUserId());

		if (existingUser.isPresent()) {
			Customer customer = existingUser.get();

			Cart cart = customer.getCart();
			Map<Product, Integer> map = cart.getProducts();

			if (map.containsKey(product)) {

				map.remove(product);

			} else {
				throw new ProductException("Product Not found in Cart");
			}

			Cart savedCart = cartdao.save(cart);

			return savedCart;
		} else {
			throw new CustomerException("User Not Found");
		}
	}
	
//	@Override
//	public Cart removeAllProducts(String key) throws ProductException, LoginException, CartException,CustomerException {
//		CurrentUserSession loggedInUser = csdao.findByUuid(key);
//
//		if (loggedInUser == null) {
//			throw new LoginException("Invalid Key Entered");
//		}
//
//		if (loggedInUser.getAdmin() == true) {
//			throw new CustomerException("Only Customer can make changes");
//		}
//
//		Optional<Customer> existingUser = customerDao.findById(loggedInUser.getUserId());
//
//		if (existingUser.isPresent()) {
//			Customer customer = existingUser.get();
//
//			Cart cart = customer.getCart();
//
//			cart.setProducts(new HashMap<>());
//
//			Cart savedCart = cartdao.save(cart);
//
//			return savedCart;
//
//		} else {
//			throw new CustomerException("User Not Found");
//		}
//	}

}
