package com.project.module;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CustomerLoginId;

	@Size(min = 3, max = 20, message = "{Customer.invalid.userName}")
	@Column(unique = true)
	private String userName;
  
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank...!")
	private String password;

	@Size(min = 2, max = 20, message = "{Customer.invalid.firstName}")
	private String firstName;

	@Size(min = 2, max = 20, message = "{Customer.invalid.lastName}")
	private String lastName;

	@NotNull(message = "MobileNumber cannot be null")
	@NotBlank(message = "MobileNumber cannot be blank...!")

	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "{user.invalid.password}")
	private String password;

	@Size(min = 2, max = 20, message = "{user.invalid.firstName}")
	private String firstName;

	@Size(min = 2, max = 20, message = "{user.invalid.lastName}")
	private String lastName;

	@Pattern(regexp = "^[0-9]{10}", message = "{user.invalid.contact}")

	private String MobileNumber;

	@Email(message = "incorrect email")
	@Column(unique = true)
	private String email;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Address> Address;
}
