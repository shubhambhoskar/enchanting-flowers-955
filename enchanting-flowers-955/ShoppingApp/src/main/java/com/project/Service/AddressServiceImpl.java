package com.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.AddressDao;
import com.project.Exceptions.AddressException;
import com.project.module.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao aDao;
	
	
//  edit this customerdao after adding its file..
//	@Autowired
//	private CustomerDao cDao;

	@Override
	public Address addAddress(Address address) throws AddressException {
		
		Address newadd= aDao.save(address);
		
		return newadd;
	}

	@Override
	public Address updateAddress(Address address) throws AddressException {
		// TODO Auto-generated method stub
		Optional<Address> updateadd = aDao.findById(address.getAddressId());
		
		if(!updateadd.isPresent()) {
			throw new AddressException("Address not not available");
		}
		return aDao.save(updateadd.get());
	}

	@Override
	public Address removeAddress(Address address) throws AddressException {
		// TODO Auto-generated method stub
		Optional<Address> deladd = aDao.findById(address.getAddressId());
		
		if(deladd.isPresent()) {
			aDao.delete(address);
			return address;
		}
		throw new AddressException("No address found with id:"+ address.getAddressId());
	}

	@Override
	public List<Address> viewAllAddress() throws AddressException {
		// TODO Auto-generated method stub
		
		List<Address> li= aDao.findAll();
		
		if(li.size()==0) {
			throw new AddressException("No address found");
		}
		return li;
	}

	
// edit this after adding customerDao..	
	@Override
	public Address viewAddress(Integer customerId) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
