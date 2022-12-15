package com.project.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.Dao.SessionDao;
import com.project.Dao.UserDao;
import com.project.Exceptions.LoginException;
import com.project.ModelDTO.CurrentUserSession;
import com.project.ModelDTO.UserDTO;
import com.project.module.User;

import net.bytebuddy.utility.RandomString;

public class loginServiceImpl implements LoginService{

	
//	@Autowired
//	private UserDao uDao;
//	
//	@Autowired
//	private SessionDao sDao;
//
//	@Override
//	public String logIntoAccount(UserDTO dto) throws LoginException {
//		
//		User existingUser=uDao.findByUsername(dto.getUsername());
//		
//		if(existingUser==null) {
//			throw new LoginException("Please Enter a valid username");
//		}
//		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingUser.getUserId());
//
//		if(validCustomerSessionOpt.isPresent()) {
//			throw new LoginException("User already Logged In");
//		}
//		
//		if(existingUser.getPassword().equals(dto.getPassword())) {
//			
//			String key= RandomString.make(6);
//	
//			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
//			
//			sDao.save(currentUserSession);
//
//			return currentUserSession.toString();
//		}
//		else
//			throw new LoginException("Please Enter a valid password");
//		
//
//	}
//
//	
//	
//	@Override
//	public String logOutFromAccount(String key) throws LoginException {
//		
//		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
//		
//		
//		if(validCustomerSession == null) {
//			throw new LoginException("User Not Logged In ..");
//			
//		}
//		
//		sDao.delete(validCustomerSession);
//		
//		return "Logged Out !";
//	}
//	
	
	
	
	
	
	
	
	
	
}
