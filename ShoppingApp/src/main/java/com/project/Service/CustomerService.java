package com.project.Service;

import java.util.List;

import com.project.Exceptions.ProductException;
import com.project.module.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer cust)throws ProductException;
	
	public Customer UpdateCustomer(Customer cust)throws ProductException;
	
	public Customer removeCustomer(Customer cust)throws ProductException;
	
	public Customer viewCustomer(Customer cust)throws ProductException;
	
	public List<Customer> viewAllCustomer(Customer cust)throws ProductException;
}
