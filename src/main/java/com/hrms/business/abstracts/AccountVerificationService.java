package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.AccountVerification;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface AccountVerificationService {
    DataResult<AccountVerification> createVerification();

    Result verify(@Valid AccountVerification verification);
}