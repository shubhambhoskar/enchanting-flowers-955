package com.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.CurrentUserSessionDao;
import com.project.Dao.CustomerDao;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.module.CurrentUserSession;
import com.project.module.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CurrentUserSessionDao cussdao;
	@Override
	public Customer saveCustomer(Customer customer) throws CustomerException {
		Customer existingUserName = customerDao.findByUserName(customer.getUserName());

		if (existingUserName != null)
			throw new CustomerException("Username already exists " + customer.getUserName());

		return customerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException, LoginException {
		CurrentUserSession loggedInUser = cussdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		if (customer.getCustomerLoginId() == loggedInUser.getUserId()) {
			return customerDao.save(customer);
		} else
			throw new LoginException("Invalid customer Details, please login first");
	}

	@Override
	public Customer deleteCustomer(String username) throws CustomerException {
		Customer existingCustomer = customerDao.findByUserName(username);

		if (existingCustomer == null)
			throw new CustomerException("Customer does not exists with this username " + username);

		customerDao.delete(existingCustomer);

		return existingCustomer;
	}

	@Override
	public Customer findByUserName(String userName) throws CustomerException {
		Customer existingCustomer = customerDao.findByUserName(userName);

		if (existingCustomer != null)
			return existingCustomer;
		else
			throw new CustomerException("Customer does not exists with this userName " + userName);
	}

	@Override
	public List<Customer> findAllCustomer() throws CustomerException {
		List<Customer> customers = customerDao.findAll();

		if (customers.isEmpty())
			throw new CustomerException("No Users Found");

		return customers;
	}

}
