package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.UserDao;
import com.project.Exceptions.UserException;
import com.project.module.User;
@Service
public class UserServiceIMPL implements UserService{

	@Autowired
	private UserDao dao;

	@Override
	public User registerUser(User u) {
		User user=dao.save(u);
		return user;
	}

	@Override
	public User Updateuser(User user) throws UserException {
		
		Optional<User> opt=dao.findById(user.getUserId());
		
		if(opt.isPresent()) {
			
			User updatedUser=dao.save(user);
			
			return updatedUser;
		}else {
			throw new UserException("Invalid User details..");
		}
		
		
	}

	@Override
	public User DeleteUserbyuserId(Integer UserId) throws UserException {
		
		
		Optional<User> opt=dao.findById(UserId);
		
		if(opt.isPresent()) {
			User existingUser=opt.get();
			dao.delete(existingUser);
			return existingUser;
		}else {
			throw new UserException("Admin DoesNot Exist With the UserID :"+UserId);
		}
		
	}
	
	


}
