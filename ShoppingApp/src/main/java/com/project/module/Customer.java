package com.project.module;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String LastName;
	private String mobileNumber;
	
	private String email;
	
	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	//@JoinTable(name = "Addresses", joinColumns = @JoinColumn(name="adrress"))
	private Address address;
//	private /* Set<Address> address=new HashSet<>(); */
	
	


	public Customer(Integer customerId, String firstName, String lastName, String mobileNumber, String email,
			Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		LastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}

	public Customer() {
		super();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + "]";
	}


	
	
	
	
	
}
