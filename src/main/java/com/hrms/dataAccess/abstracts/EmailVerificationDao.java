package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer> {
}
