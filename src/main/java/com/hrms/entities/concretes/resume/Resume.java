package com.hrms.entities.concretes.resume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hrms.entities.concretes.Candidate;
import com.hrms.entities.concretes.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="resumes")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne()
    @JoinColumn(name = "candidate_id", updatable = false, referencedColumnName = "id")
    private Candidate candidate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
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
