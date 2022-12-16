package com.project.Service;

import com.project.Exceptions.AddressException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.module.Address;

public interface AddressServices {
	public Address addAddress(Address address, String key) throws AddressException,CustomerException, LoginException;
}
