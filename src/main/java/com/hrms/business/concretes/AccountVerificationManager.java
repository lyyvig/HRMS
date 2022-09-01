package com.hrms.business.concretes;

import com.hrms.business.abstracts.AccountVerificationService;
import com.hrms.business.abstracts.StaffService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.AccountVerificationDao;
import com.hrms.entities.concretes.AccountVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountVerificationManager implements AccountVerificationService {
    @Autowired
    private AccountVerificationDao verificationDao;

    @Override
    public DataResult<AccountVerification> createVerification() {
        AccountVerification verification = new AccountVerification(0, null, false, "");
        return new SuccessDataResult<>(verification);
    }

    @Override
    public Result verify(AccountVerification verification) {
        if (verificationDao.existsById(verification.getId())) {
            verification.setVerified(true);
            verificationDao.save(verification);
            return new SuccessResult(Messages.ACCOUNT_HAS_BEEN_VERIFIED);
        }
        return new ErrorResult(Messages.ACCOUNT_VERIFICATION_DOES_NOT_EXISTS);
    }
}
