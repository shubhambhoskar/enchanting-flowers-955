package com.project.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Service.CustomerService;
import com.project.module.Customer;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/users/{username}")
	public ResponseEntity<Customer> getUserDetailsHandler(@PathVariable String username) throws CustomerException {

		Customer existingCustomer = customerService.findByUserName(username);

		return new ResponseEntity<Customer>(existingCustomer, HttpStatus.OK);

	}

	@GetMapping("/users")
	public ResponseEntity<List<Customer>> getAllUserDetailsHandler() throws CustomerException {

		List<Customer> CustomerList = customerService.findAllCustomer();

		return new ResponseEntity<List<Customer>>(CustomerList, HttpStatus.OK);

	}

	@PostMapping("/users")
	public ResponseEntity<Customer> registerUserHandler(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer savedCustomer = customerService.saveCustomer(customer);

		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.OK);

	}

	@PutMapping("/users")
	public ResponseEntity<Customer> updateUserHandler(@Valid @RequestBody Customer customer, @RequestParam("key") String key)
			throws CustomerException, LoginException {

		Customer updatedCustomer = customerService.updateCustomer(customer, key);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);

	}

	@DeleteMapping("/users/{username}")
	public ResponseEntity<Customer> deleteUserHandler(@PathVariable("username") String username)
			throws CustomerException, LoginException {

		Customer updatedCustomer = customerService.deleteCustomer(username);

		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);

	}
}
