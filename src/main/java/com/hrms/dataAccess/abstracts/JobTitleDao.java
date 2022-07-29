package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
    boolean existsByTitle(String title);

}