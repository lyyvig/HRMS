package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    boolean existsCandidateByNationalIdentity(String nationalIdentity);
    boolean existsByUser_Email(String email);

    @Query("select c from Candidate c where c.emailVerification.verified = true")
    List<Candidate> findVerifiedCandidates();



}
