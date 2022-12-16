package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;
import com.project.Dao.AdminDao;
import com.project.Dao.CurrentUserSessionDao;
import com.project.Dto.AdminDto;
import com.project.Dto.CustomerDto;
import com.project.Exceptions.LoginException;
import com.project.module.Admin;
import com.project.module.CurrentUserSession;
import com.project.module.Customer;

import net.bytebuddy.utility.RandomString;

public class LoginServiceImpl implements LoginService{


	@Autowired
	private AdminDao admindao;

	@Autowired
	private CustomerDao customerRepo;

	@Autowired
	private CurrentUserSessionDao currUserSession;
	
	
	@Override
	public String loginAdmin(AdminDto admin) throws LoginException {
		
		Admin existingUser = admindao.findByAdminUsername(admin.getAdminUsername());

		if (existingUser == null)
			throw new LoginException("Invalid credentials. Username does not exist " + admin.getAdminUsername());

		Optional<CurrentUserSession> validCustomerSessionOpt = currUserSession.findById(existingUser.getAdminId());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this username");

		}

		if (existingUser.getAdminPassword().equals(admin.getAdminPassword())) {

			String key = RandomString.make(6);

			Boolean isAdmin = true;

			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getAdminId(), key, isAdmin,
					LocalDateTime.now());

			currUserSession.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logoutAdmin(String key) throws LoginException {
		CurrentUserSession validCustomerSession = currUserSession.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this username");

		}

		currUserSession.delete(validCustomerSession);

		return "Logged Out !";
	}

	@Override
	public String loginCustomer(CustomerDto user) throws LoginException {
		
		Customer existingCustomer = customerRepo.findByUserName(user.getUserName());

		if (existingCustomer == null)
			throw new LoginException("Invalid credentials. Username does not exist " + user.getUserName());

		Optional<CurrentUserSession> validCustomerSessionOpt = currUserSession.findById(existingCustomer.getCustomerLoginId());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this username");

		}

		if (existingCustomer.getPassword().equals(user.getPassword())) {

			String key = RandomString.make(6);
			
			Boolean isAdmin = false;

			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerLoginId(), key, isAdmin,
					LocalDateTime.now());

			currUserSession.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");
		
		
	}

	@Override
	public String logoutCustomer(String key) throws LoginException {
		
		CurrentUserSession validCustomerSession = currUserSession.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this username");

		}

		currUserSession.delete(validCustomerSession);

		return "Logged Out !";
	
	}

	

	
	
	
}
