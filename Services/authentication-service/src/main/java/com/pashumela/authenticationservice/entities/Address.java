package com.pashumela.authenticationservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "address")
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pincode")
	private Long pincode;
	
	@Column(name = "district")
	private String district;
	
	
	@Column(name = "state")
	private String state;

	public Address() {
		super();
	}

	public Address(Long id, String street, String landmark, String city,Long pincode, String district, String state) {
		super();
		this.id = id;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.district = district;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", landmark=" + landmark + ", city=" + city + ", district="
				+ district + ", state=" + state +" ]";
	}
	
	
}
