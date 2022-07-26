package com.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@Entity
public class Candidate {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "national_identity")
	private String nationalIdentity;

	@Column(name = "birth_year")
	private int birthYear;
}