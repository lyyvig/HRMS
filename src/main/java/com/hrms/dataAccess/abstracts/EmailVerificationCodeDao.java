package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.EmailVerificationCode;

public interface EmailVerificationCodeDao extends JpaRepository<EmailVerificationCode, Integer> {

}