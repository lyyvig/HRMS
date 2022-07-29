package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.JobOffer;

import java.util.List;

public interface JobOfferDao extends JpaRepository<JobOffer, Integer> {
    List<JobOffer> findByActiveIsTrue();

}