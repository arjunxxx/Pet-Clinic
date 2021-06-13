package com.technolearns.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // To specify that its just a parent class and do not need separate column in
					// DB. It just gives attributes to sub classes.
public class Person extends BaseEntity {

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

}
