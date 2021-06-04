package com.technolearns.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pets")
public class Pet extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@Column(name="birth_day")
	private LocalDate birthday;
	
	@ManyToOne
	@JoinColumn(name="pet_type_id")
	private PetType petType;
	
	@Column(name="name")
	private String name;

	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
