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
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.AddressException;
import com.project.Service.AddressService;
import com.project.module.Address;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addressadd")
	public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address)throws AddressException{
		
		Address newadd= addressService.addAddress(address);
		
		return new ResponseEntity<Address>(newadd,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/addressupdate")
	public ResponseEntity<Address> updateAddress(@Valid @RequestBody Address address) throws AddressException{
		
		
		Address updatedAddress= addressService.updateAddress(address);
		
		
		return new ResponseEntity<Address>(updatedAddress, HttpStatus.ACCEPTED);
	
	}
	
	
	
	
	@GetMapping("/address/{customerId}")
	public ResponseEntity<Address> viewAddress(@PathVariable("customerId") Integer customerId) throws AddressException{
		
		
	    Address viewAddress= addressService.viewAddress(customerId);
		
		
		return new ResponseEntity<Address>(viewAddress, HttpStatus.OK);
	}

	
	@DeleteMapping("address/delete")
	public ResponseEntity<Address> deleteaddress(@RequestBody Address address) throws AddressException{
		
		
	    Address delAdd= addressService.removeAddress(address);		
		
		return new ResponseEntity<Address>(delAdd, HttpStatus.OK);
	}
	
	@GetMapping("/address/view")
	public ResponseEntity<List<Address>> listOfAddress() throws AddressException{
		
		
		List<Address> li= addressService.viewAllAddress();
		
		
		return new ResponseEntity<List<Address>>(li, HttpStatus.OK);
	
	}


//// customerID pending

}
