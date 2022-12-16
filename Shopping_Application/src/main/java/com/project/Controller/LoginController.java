package com.project.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Dao.AdminDao;
import com.project.Dto.AdminDto;
import com.project.Dto.CustomerDto;
import com.project.Exceptions.LoginException;
import com.project.Service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/adminLogin")
	public ResponseEntity<String> loginAdminHandler(@Valid @RequestBody AdminDto admin) throws LoginException {

		String res = loginService.loginAdmin(admin);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	
	@PostMapping("/adminLogout")
	public ResponseEntity<String> logoutAdminHandler(@RequestParam("key") String key) throws LoginException {

		String res = loginService.logoutAdmin(key);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	
	@PostMapping("/customerLogin")
	public ResponseEntity<String> loginUserHandler(@Valid @RequestBody CustomerDto customer) throws LoginException {

		String res = loginService.loginCustomer(customer);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	
	@PostMapping("/customerLogout")
	public ResponseEntity<String> logoutUserHandler(@RequestParam("key") String key) throws LoginException {

		String res = loginService.logoutCustomer(key);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	
	
}
