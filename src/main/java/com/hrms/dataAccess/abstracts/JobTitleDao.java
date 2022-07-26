package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

}