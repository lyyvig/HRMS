package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="account_verifications")
@Entity
public class AccountVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "reviewer_id", referencedColumnName = "id")
	private Staff reviewer;

	@Column(name = "verified")
	private boolean verified;

	@NotNull
	@Column(name = "message")
	private String message;
}