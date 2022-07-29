package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    boolean existsByUser_Email(String email);

    @Query("""
            select e from Employer e
            where e.user.emailVerified = true and e.user.accountVerified = true""")
    List<Employer> findVerifiedEmployers();




}