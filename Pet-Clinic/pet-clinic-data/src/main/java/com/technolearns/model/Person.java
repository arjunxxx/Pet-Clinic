package com.technolearns.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //To specify that its just a parent class and do not need separate column in DB. It just gives attributes to sub classes.
public class Person extends BaseEntity {
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;

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
	
	

}
