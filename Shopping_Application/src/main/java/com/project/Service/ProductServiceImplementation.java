package com.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CategoryDao;
import com.project.Dao.CurrentUserSessionDao;
import com.project.Dao.ProductDao;
import com.project.Exceptions.AdminException;
import com.project.Exceptions.CategoryException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Exceptions.ProductException;
import com.project.module.Category;
import com.project.module.CurrentUserSession;
import com.project.module.Product;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CurrentUserSessionDao csdao;

	@Override
	public Product addProduct(Product product, Integer id, String key)throws ProductException, AdminException, LoginException {
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == false) {
			throw new AdminException("Unauthorized Access! Only Admin can make changes");
		}

		Optional<Category> otp = categoryDao.findById(id);
		Category category = otp.get();
		if (category != null) {
			
			    product.setCategory(category.getCategoryName());
			    return productDao.save(product);
		} else {
			throw new ProductException("product detail is not correct");
		}
	}

	@Override
	public Product updateProduct(Product product, Integer id, String key)throws ProductException, AdminException, LoginException {
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == false) {
			throw new AdminException("Unauthorized Access! Only Admin can make changes");
		}
		
		Optional<Category> otp1 = categoryDao.findById(id);
		Optional<Product> otp2 = productDao.findById(product.getProductId());
		Category category = otp1.get();
		if (category != null && otp2.isPresent()) {
			
			    product.setCategory(category.getCategoryName());
			    Product savedproduct = productDao.save(product);
			    return savedproduct;
		} else {
			throw new ProductException("product detail is not correct");
		}
	}

	@Override
	public Product deleteProduct(Integer productId, String key)throws ProductException, AdminException, LoginException {
		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new LoginException("Invalid Key Entered");
		}

		if (loggedInUser.getAdmin() == false) {
			throw new AdminException("Unauthorized Access! Only Admin can make changes");
		}
		
		Optional<Product> otp2 = productDao.findById(productId);
		if (otp2.isPresent()) {
			Product existingProduct = otp2.get();
			productDao.deleteById(productId);
			return existingProduct;
		} else {
			throw new ProductException("Product not exited with this ProductId " + productId);
		}
	}

	@Override
	public Product viewProductByid(Integer productId) throws ProductException {
		Optional<Product> otp2 = productDao.findById(productId);
		if (otp2.isPresent()) {
			Product existingProduct = otp2.get();
			return existingProduct;
		} else {
			throw new ProductException("Product not exited with this ProductId " + productId);
		}
	}

	@Override
	public List<Product> viewProductByCategory(String category) throws ProductException {
		List<Product> listOfproduct = productDao.findByCategory(category);

		if (listOfproduct.size() > 0)
			return listOfproduct;
		else {
			throw new ProductException("Product does not exist with such category : " + category);
		}
	}

	@Override
	public List<Product> viewAllProduct() throws ProductException {
		List<Product> listOfproduct = productDao.findAll();

		if (listOfproduct.size() > 0)
			return listOfproduct;
		else {
			throw new ProductException("No product exist...");
		}
	}

	
	


}
