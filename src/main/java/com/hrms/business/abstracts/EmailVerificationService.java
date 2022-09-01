package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.EmailVerification;

public interface EmailVerificationService {
    DataResult<EmailVerification> createVerification();

    Result verify(EmailVerification verification);
}
