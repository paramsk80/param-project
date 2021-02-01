package com.example.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Valid
	@NotBlank(message = "First Name is Mandatory")
	@Column(name = "first_name")
	private String firstName;

	@Valid
	@NotBlank(message = "Last Name is Mandatory")
	@Column(name = "last_name")
	private String lastName;

	@Valid
	@NotBlank(message = "Email is Mandatory")
	private String email;

	@Valid
	@NotBlank(message = "Phone number is Mandatory")
	private String phone;

}
