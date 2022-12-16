package com.project.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.AddressException;
import com.project.Exceptions.CustomerException;
import com.project.Exceptions.LoginException;
import com.project.Service.AddressServices;
import com.project.module.Address;

@RestController
public class AddressController {
	
	@Autowired
	private AddressServices addressServices;

	@PostMapping("/address")
	public ResponseEntity<Address> addReservation(@Valid @RequestBody Address address,@RequestParam String key) throws AddressException, CustomerException, LoginException{

		Address savedAddress = addressServices.addAddress(address, key);

		return new ResponseEntity<Address>(savedAddress, HttpStatus.ACCEPTED);

	}

}
