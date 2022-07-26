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
@Table(name="email_verification_codes")
@Entity
public class EmailVerificationCode {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "verification_code")
	private short verificationCode;
}