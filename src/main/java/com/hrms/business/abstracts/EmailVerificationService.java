package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.EmailVerification;
import com.hrms.entities.concretes.User;

public interface EmailVerificationService {
    Result createVerification(User user);
    Result verify(EmailVerification verification);
}
