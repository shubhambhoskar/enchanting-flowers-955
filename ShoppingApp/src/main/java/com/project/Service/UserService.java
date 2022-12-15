package com.project.Service;

import com.project.Exceptions.UserException;
import com.project.module.User;

public interface UserService {

	public User registerUser(User u);
	
	public User Updateuser(User Updateddata)throws UserException;

	public User DeleteUserbyuserId(Integer UserId)throws UserException;


}
