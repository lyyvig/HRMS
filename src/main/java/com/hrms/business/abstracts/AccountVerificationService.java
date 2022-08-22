package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.AccountVerification;

public interface AccountVerificationService {
    DataResult<AccountVerification> createVerification();
    Result verify(AccountVerification verification);
}