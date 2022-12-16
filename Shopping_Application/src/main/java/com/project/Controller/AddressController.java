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
	
	@PutMapping("/address/{addressId}")
	public ResponseEntity<Address> updateAddress(@Valid @RequestBody Address address,@PathVariable("addressId") Integer addressId, @RequestParam String key)
			throws AddressException, CustomerException, LoginException{

		Address savedAddress = addressServices.updateAddress(address, addressId, key);

		return new ResponseEntity<Address>(savedAddress, HttpStatus.ACCEPTED);

	}

	@GetMapping("/address/{addressId}")
	public ResponseEntity<Address> getAddressById(@PathVariable("addressId") Integer addressId,
			@RequestParam String key) throws AddressException, CustomerException, LoginException{

		Address address = addressServices.viewAddress(addressId, key);

		return new ResponseEntity<Address>(address, HttpStatus.ACCEPTED);

	}

	@GetMapping("/address")
	public ResponseEntity<List<Address>> viewAllAddressHandler(@RequestParam String key)
			throws AddressException, LoginException, CustomerException {

		List<Address> address = addressServices.viewAllAddress(key);

		return new ResponseEntity<List<Address>>(address, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/address/{addressId}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("addressId") Integer addressId,
			@RequestParam String key) throws AddressException, LoginException, CustomerException{
		
		Address deletedAddress = addressServices.deleteAddress(addressId, key);
		
		return new ResponseEntity<Address>(deletedAddress, HttpStatus.OK);
	}


}
