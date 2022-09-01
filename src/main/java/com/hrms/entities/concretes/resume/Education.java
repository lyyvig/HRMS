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
@Table(name = "educations")
@Entity
public class Education {
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
    @Column(name = "school_name")
    private String schoolName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "department")
    private String department;

    @NotNull
    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "graduation_date")
    private Date graduationDate;


}
