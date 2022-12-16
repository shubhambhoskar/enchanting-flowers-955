package com.project.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.AddressDao;
import com.project.Dao.CurrentUserSessionDao;
import com.project.Dao.CustomerDao;
import com.project.Exceptions.AddressException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.module.Address;
import com.project.module.CurrentUserSession;
import com.project.module.Customer;

@Service
public class AddressServicesImpl implements AddressServices{
	@Autowired
	private AddressDao addressDao;


	@Autowired
	private CurrentUserSessionDao csdao;

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public Address addAddress(Address address, String key) throws AddressException, CustomerException, LoginException {
		
		CurrentUserSession loggedInCustomer = csdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}
		Customer customer = customerService.findByCustomerLoginId(loggedInCustomer.getUserId());

		Set<Address> res = customer.getAddress();

		if (res.contains(address))
			throw new AddressException("Address already exists");

		customer.getAddress().add(address);

		return addressDao.save(address);
	}

}