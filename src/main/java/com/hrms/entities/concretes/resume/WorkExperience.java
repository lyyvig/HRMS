package com.hrms.entities.concretes.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "work_experiences")
@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "resume_id", updatable = false, nullable = false, referencedColumnName = "id")
    private Resume resume;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "job_title")
    private String jobTitle;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
