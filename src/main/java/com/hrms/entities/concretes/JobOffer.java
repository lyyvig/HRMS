package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_offers")
@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employerId", updatable = false, nullable = false, referencedColumnName = "id")
    private Employer employer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_title_id", nullable = false, referencedColumnName = "id")
    private JobTitle jobTitle;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, referencedColumnName = "id")
    private City city;

    @NotNull
    @Size(min = 2, max = 500)
    @Column(name = "description")
    private String description;

    @NotNull
    @Min(1)
    @Column(name = "number_of_recruitment")
    private int numberOfRecruitment;

    @NotNull
    @Column(name = "publish_date")
    private Date publishDate;

    @NotNull
    @Column(name = "closing_date")
    private Date closingDate;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @Column(name = "active")
    private boolean active;
}