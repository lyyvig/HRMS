package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@Entity
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
	private User user;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email_verification_id", nullable = false, referencedColumnName = "id")
	private EmailVerification emailVerification;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 50)
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@NotBlank
	@Size(min = 11, max = 11)
	@Column(name = "national_identity")
	private String nationalIdentity;

	@NotNull
	@Column(name = "birth_year")
	private int birthYear;



}