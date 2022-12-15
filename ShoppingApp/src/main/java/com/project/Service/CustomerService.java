package com.project.Service;

import java.util.List;

import com.project.Exceptions.ProductException;
import com.project.module.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer cust)throws ProductException;
	
	public Customer updateCustomer(Customer cust)throws ProductException;
	
	public Customer removeCustomer(Integer cid)throws ProductException;
	
	public Customer viewCustomer(Integer cid)throws ProductException;
	
	public List<Customer> viewAllCustomer()throws ProductException;
}
