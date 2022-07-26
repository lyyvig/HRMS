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
@Table(name="users")
@Entity
public class User {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
}