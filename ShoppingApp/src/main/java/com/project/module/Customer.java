package com.project.module;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	
	@Column(name="CustomerId")
	private Integer customerId;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LirstName")
	private String LastName;
	
	@Column(name="MobileNumber")
	private String mobileNumber;
	
	private String email;
	
	@OneToMany
	@JoinColumn(name ="CustmerId")
	@Cascade(CascadeType.ALL)
	private List<Address> address = new ArrayList<>();

	public Customer() {
		super();
	}
	
	
	public Customer(Integer customerId, String firstName, String lastName, String mobileNumber, String email,
			List<Address> address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		LastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + "]";
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
	
	
	public List<Address> getAddress() {
		return address;
	}
	
	
	public void setAddress(List<Address> address) {
		this.address = address;
	} 
		

	
	
	
}
