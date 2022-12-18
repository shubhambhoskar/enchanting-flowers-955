package com.project.Service;

import java.util.List;
import java.util.Optional;
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
		customer.setAddresses(address);
		return addressDao.save(address);
	}

	@Override
	public Address updateAddress(Address address, Integer AddressId, String key)throws AddressException, CustomerException, LoginException {
		CurrentUserSession loggedInCustomer = csdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		Optional<Address> existingAddress = addressDao.findById(AddressId);

		if (existingAddress.isPresent() == false)
			throw new AddressException("No Address found!");

		Address res = existingAddress.get();

		return addressDao.save(address);
	}

	@Override
	public Address deleteAddress(Integer AddressId, String key)throws AddressException, CustomerException, LoginException {
		CurrentUserSession loggedInCustomer = csdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new LoginException("Invalid Key Entered");
		}

		Optional<Address> existingAddress = addressDao.findById(AddressId);

		if (existingAddress.isPresent() == false)
			throw new AddressException("No Address found!");
		
		Address adr = existingAddress.get();
		
		Customer customer = customerService.findByCustomerLoginId(loggedInCustomer.getUserId());
		
		customer.setAddresses(null);

		addressDao.deleteById(AddressId);

		return adr;
	}

	@Override
	public Address viewAddress(Integer AddressId, String key) throws AddressException, CustomerException {
		
		CurrentUserSession loggedInCustomer = csdao.findByUuid(key);

		if (loggedInCustomer == null) {
			throw new CustomerException("Customer not logged in");
		}

		Optional<Address> existingAddress = addressDao.findById(AddressId);

		if (existingAddress.isPresent() == false)
			throw new AddressException("No address found!");

		return existingAddress.get();
	}

	@Override
	public List<Address> viewAllAddress(String key) throws AddressException, CustomerException {
		CurrentUserSession loggedInCustomer = csdao.findByUuid(key);
		
		if (loggedInCustomer == null) {
			throw new CustomerException("Customer not logged in");
		}

		List<Address> address = addressDao.findAll();

		if (address.isEmpty())
			throw new AddressException("No address found!");

		return address;
	}

}
