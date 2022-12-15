package com.project.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CustomerDao;
import com.project.Exceptions.ProductException;
import com.project.Service.CustomerService;
import com.project.module.Customer;



@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cDao;
	
	@Override
	public Customer addCustomer(Customer cust) throws ProductException {
		System.out.println("Akashyadav====================================2222222222222222222222222");
		System.out.println(cust.getAddress().isEmpty());
		Customer cst = cDao.save(cust);
		if(cst!=null) {
			
			return cst;
		}else {
			throw new ProductException("Invalid customer details..");
		}
	}

	@Override
	public Customer updateCustomer(Customer cust) throws ProductException {
		
			Optional<Customer> ctr = cDao.findById(cust.getCustomerId());
			if(ctr.isPresent()) {
				cDao.save(cust);
				return ctr.get();
			}else {
				throw new ProductException("Invalid Custome dedatils..");
			}
	}

	@Override
	public Customer removeCustomer(Integer cid) throws ProductException {
	Optional<Customer> c = cDao.findById(cid);
		
		if(c.isPresent()) {
			cDao.deleteById(cid);
			return c.get();
		}else {
			throw new  ProductException("Invalid customer ID..");
		}

	}

	@Override
	public Customer viewCustomer(Integer cid) throws ProductException {
		Optional<Customer> c = cDao.findById(cid);
		if(c!=null) {
			return c.get();
		}else{
			throw new  ProductException("Invalid customer ID..");
		}
	}

	@Override
	public List<Customer> viewAllCustomer() throws ProductException {
		List<Customer> list = cDao.findAll();
		if(list.size()>0) {
			return list;
		}else {
			throw new ProductException("Empty customer list");
		}

	}

	
}
