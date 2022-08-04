package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
    Resume findByCandidate_Id(int id);
    boolean existsByCandidate_Id(int id);
}
