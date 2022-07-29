package com.hrms.dataAccess.abstracts;

import com.hrms.entities.concretes.AccountVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountVerificationDao extends JpaRepository<AccountVerification, Integer> {

}
