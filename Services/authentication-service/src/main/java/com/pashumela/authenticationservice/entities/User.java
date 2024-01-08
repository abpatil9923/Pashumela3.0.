package com.pashumela.authenticationservice.entities;


import org.hibernate.validator.constraints.Length;

import com.pashumela.authenticationservice.constants.UserConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "user")
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	
	@NotBlank(message = "first name is mandatory")
	@Length(max = UserConstants.MAX_FIRST_NAME)
	@Column(name = "first_name", length = UserConstants.MAX_FIRST_NAME)
	private String firstName;
	
	@NotBlank(message = "last name is mandatory")
	@Length(max = UserConstants.MAX_LAST_NAME)
	@Column(name = "last_name", length = UserConstants.MAX_LAST_NAME)
	private String lastName;
	
	@NotBlank(message = "mobile number is mandatory")
	@Column(name = "mobile_number", length = UserConstants.MAX_MOBILE_NUMBER)
	private String mobileNumber;
	
	@Column(name = "email_id")
	private String emailId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
	private Address address;

	public User() {
		super();
	}

	public User(Long userId, String firstName,String lastName,String mobileNumber, String emailId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", address=" + address + "]";
	}
	
}
