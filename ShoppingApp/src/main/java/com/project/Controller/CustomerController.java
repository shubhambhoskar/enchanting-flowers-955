package com.project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;


import com.project.Exceptions.ProductException;
import com.project.Service.CustomerService;
import com.project.module.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer cust) throws ProductException {
		Customer c = null;
		try {
			c = cService.addCustomer(cust);
		} catch (ProductException e) {
			throw new ProductException("Something wrong by ===================");
		}
		
		return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);

	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateUserPasswordHandler(@RequestBody Customer cust) throws ProductException{
		
		Customer c;
		try {
			c = cService.updateCustomer(cust);
		} catch (ProductException e) {
			throw new ProductException("Invalid customer details..");
		}
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{cid}")
	public ResponseEntity<Customer>deleteustomerByIdHandler(@PathVariable("cid") Integer cid) throws ProductException{
		Customer c;
		try {
			c = cService.removeCustomer(cid);
		} catch (ProductException e) {
			throw new ProductException(e.getMessage());
		}
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{cid}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("cid") Integer cid) throws ProductException{
		
		Customer c = cService.viewCustomer(cid);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> allCustomerListHandler() throws ProductException{
		List<Customer> c = cService.viewAllCustomer();
		return new ResponseEntity<List<Customer>>(c,HttpStatus.OK);
	}


	
	
	
	
}
