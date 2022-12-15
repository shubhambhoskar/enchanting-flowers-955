package com.project.Service;

import java.util.List;

import com.project.Exceptions.AddressException;
import com.project.module.Address;

public interface AddressService {
	

	public Address addAddress(Address address) throws AddressException;
	
	public Address updateAddress(Address address) throws AddressException;
	
	
	public Address removeAddress(Address address)throws AddressException;
	
	public List<Address> viewAllAddress() throws AddressException;
	
	public Address viewAddress(Integer customerId) throws AddressException;

}
