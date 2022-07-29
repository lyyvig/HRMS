package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.AccountVerification;
import com.hrms.entities.concretes.User;

public interface AccountVerificationService {
    Result createVerification(User user);
    Result verify(AccountVerification verification);
}