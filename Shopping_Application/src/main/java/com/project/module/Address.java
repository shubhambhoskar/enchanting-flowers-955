package com.project.module;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(buildingName, other.buildingName)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(state, other.state)
				&& Objects.equals(streetNo, other.streetNo);
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressId, buildingName, city, country, pincode, state, streetNo);
	}
	


}
