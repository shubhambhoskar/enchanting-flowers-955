package com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Exceptions.LoginException;
import com.project.ModelDTO.UserDTO;
import com.project.Service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class LoginController {

//	@Autowired
//	private LoginService userLogin;
//	
//	@PostMapping("/login")
//	public ResponseEntity<String> logInCustomer(@RequestBody UserDTO dto) throws LoginException {
//		
//		String result = userLogin.logIntoAccount(dto);
//		
//		return new ResponseEntity<String>(result,HttpStatus.OK );
//				
//	}
//	
//	@PostMapping("/logout")
//	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
//		return userLogin.logOutFromAccount(key);
//		
//	}
//	
	
	
}
