package com.project.module;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String firstName;
	private String LastName;
	private String mobileNumber;
	
	private String email;
	
	@ElementCollection
	@Embedded
	@JoinTable(name = "Addresses", joinColumns = @JoinColumn(name="adrress"))
	private Set<Address> addresses=new HashSet<Address>();
	
	
	
	
	
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", addresses=" + addresses + "]";
	}

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String firstName, String lastName, String mobileNumber, String email,
			Set<Address> addresses) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		LastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.addresses = addresses;
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	
	
	
}
