package com.project.Service;

import com.project.Dto.AdminDto;
import com.project.Dto.CustomerDto;
import com.project.Exceptions.LoginException;

public interface LoginService {

	public String loginAdmin(AdminDto admin) throws LoginException;
	
	public String logoutAdmin(String key) throws LoginException;
	
	public String loginCustomer(CustomerDto user) throws LoginException;
	
	public String logoutCustomer(String key) throws LoginException;
	
}
