package com.project.Service;

import java.util.List;

import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.module.Customer;

public interface CustomerService {
	public Customer saveCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer, String key) throws CustomerException, LoginException;

	public Customer deleteCustomer(String username) throws CustomerException;

	public Customer findByUserName(String userName) throws CustomerException;
	
	public List<Customer> findAllCustomer() throws CustomerException;
	
	public Customer findByCustomerLoginId(Integer CustomerLoginId) throws CustomerException;
}
