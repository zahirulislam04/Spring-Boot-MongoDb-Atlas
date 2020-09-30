package com.project.mongodb.model;

public class Author {
	private String name;
	private String email;
	private String city;
	private String country;
	
	
	
	public Author(String name, String email, String city, String country) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", city=" + city + ", country=" + country + "]";
	}
	
	
}
