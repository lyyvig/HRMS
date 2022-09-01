package com.hrms.entities.concretes.resume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hrms.entities.concretes.Candidate;
import com.hrms.entities.concretes.Image;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "resumes")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "candidate_id", updatable = false, nullable = false, referencedColumnName = "id")
    private Candidate candidate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", nullable = false, referencedColumnName = "id")
    private Image image;

    @Column(name = "summary")
    private String summary;

    @JsonManagedReference
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Education> educations;

    @JsonManagedReference
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<KnownLanguage> knownLanguages;

    @JsonManagedReference
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @JsonManagedReference
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Website> websites;

    @JsonManagedReference
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    private List<WorkExperience> workExperiences;


}
