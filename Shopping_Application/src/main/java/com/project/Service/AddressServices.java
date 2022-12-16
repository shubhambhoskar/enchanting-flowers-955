package com.project.Service;

import java.util.List;

import com.project.Exceptions.AddressException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.module.Address;

public interface AddressServices {
	public Address addAddress(Address address, String key) throws AddressException,CustomerException, LoginException;
	
	public Address updateAddress(Address address, Integer AddressId, String key) throws AddressException,CustomerException, LoginException ;
	
	public Address deleteAddress(Integer AddressId, String key) throws AddressException,CustomerException, LoginException;
	
	public Address viewAddress(Integer AddressId,String key) throws AddressException,CustomerException;
	
	public List<Address> viewAllAddress(String key)throws AddressException,CustomerException;
}
