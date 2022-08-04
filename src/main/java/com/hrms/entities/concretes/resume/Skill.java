package com.hrms.entities.concretes.resume;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="skills")
@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ToString.Exclude
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "resume_id", updatable = false, referencedColumnName = "id", nullable=false)
	private Resume resume;

	@Column(name = "skill_name")
	private String skillName;
}