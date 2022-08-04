package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_offers")
@Entity
public class JobOffer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "employerId", updatable = false, referencedColumnName = "id")
	private Employer employer;

	@OneToOne
	@JoinColumn(name = "job_title_id", updatable = false, referencedColumnName = "id")
	private JobTitle jobTitle;

	@OneToOne
	@JoinColumn(name = "city_id", updatable = false, referencedColumnName = "id")
	private City city;

	@Column(name = "description")
	private String description;

	@Column(name = "number_of_recruitment")
	private int numberOfRecruitment;

	@Column(name = "publish_date")
	private Date publishDate;

	@Column(name = "closing_date")
	private Date closingDate;

	@Column(name = "min_salary")
	private Integer minSalary;

	@Column(name = "max_salary")
	private Integer maxSalary;

	@Column(name = "active")
	private boolean active;
}