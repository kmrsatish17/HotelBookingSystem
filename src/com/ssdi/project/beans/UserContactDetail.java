package com.ssdi.project.beans;

public class UserContactDetail {
	
	private String firstname;
	
	private String lastname;
	
	private String username;
	
	private String address1; 
	
	 private String address2;
	 
	 private String city; 
	 
	 private String state; 
	 
	 private String country; 
	 
	 private String zip;
	 
	 private String phoneNumber;
	 
	 public UserContactDetail(){
		 
	 }
	 	
	
	public UserContactDetail(String firstname, String lastname, String username, String address1, String address2,
			String city, String state, String country, String zip, String phoneNumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	 
	 

}
