package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    boolean existsCandidateByNationalIdentity(String nationalIdentity);
    boolean existsByUser_Email(String email);

    @Query("""
            select c from Candidate c
            where c.user.emailVerified = true and c.user.accountVerified = true""")
    List<Candidate> findVerifiedCandidates();



}
