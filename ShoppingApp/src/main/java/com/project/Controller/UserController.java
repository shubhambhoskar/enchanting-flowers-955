package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.UserException;
import com.project.Service.UserService;
import com.project.module.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

	@Autowired
	private UserService SService;
	
	@PostMapping("/user")
	public ResponseEntity<User> registerUserHandler(User user){
		
		User u=SService.registerUser(user);
		
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> UpdateuseHandler(@RequestBody User user) throws UserException{
		
		User updateduser=SService.Updateuser(user);
		
		return new ResponseEntity<User>(updateduser,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<User> RemoveHandler(@PathVariable("userId") Integer userID) throws UserException{
	
		User deleteduser=SService.DeleteUserbyuserId(userID);
		
		return new ResponseEntity<User>(deleteduser,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
}
