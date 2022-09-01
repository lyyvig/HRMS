package com.hrms.entities.concretes.resume;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "known_languages")
@Entity
public class KnownLanguage {
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
    @Column(name = "language")
    private String language;

    @NotNull
    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;
}