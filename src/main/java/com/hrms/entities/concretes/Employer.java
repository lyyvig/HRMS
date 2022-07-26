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
@Table(name="employers")
@Entity
public class Employer {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website_address")
	private String websiteAddress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "verified")
	private boolean verified;

	@Column(name = "email_verified")
	private boolean emailVerified;
}