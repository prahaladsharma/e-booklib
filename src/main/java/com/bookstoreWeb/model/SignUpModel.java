package com.bookstoreWeb.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jayway.jsonpath.internal.function.numeric.Min;

@Entity
@Table(name="user_register")
@EntityListeners(AuditingEntityListener.class)
public class SignUpModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@NotBlank
	@Size(max=40)
	private String name;
	
	@NotBlank
	@Size(max=40)
	private String address;
	
	@NotBlank
	@Size(max=40)
	private String city;
	
	@NotBlank
	@Size(max=40)
	private String state;
	
	@NotBlank
	@Size(max=40)
	private String country;
	
	@NotBlank
	@Size(max=10)
	private String mobileNumber;
	
	@NotBlank
	@Size(max=40)
	private String email;
	
	@NotBlank
	@Size(max=16)
	private String password;
	
	public SignUpModel() {}
	

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param country
	 * @param mobileNumber
	 * @param email
	 * @param password
	 */
	public SignUpModel(String name, @NotBlank @Size(max = 40) String address,
						@NotBlank @Size(max = 40) String city, @NotBlank @Size(max = 40) String state,
						@NotBlank @Size(max = 40) String country, @NotBlank @Size(max = 10) String mobileNumber,
						@NotBlank @Size(max = 40) String email, @NotBlank @Size(max = 16) String password) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return Id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		Id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SignUpModel [email=" + email + "]";
	}
		
	
	
}
