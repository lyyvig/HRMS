package com.hrms.business.concretes;

import com.hrms.business.abstracts.AccountVerificationService;
import com.hrms.business.abstracts.StaffService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.AccountVerificationDao;
import com.hrms.entities.concretes.AccountVerification;
import com.hrms.entities.concretes.Staff;
import com.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountVerificationManager implements AccountVerificationService {
    private AccountVerificationDao verificationDao;
    private StaffService staffService;

    @Autowired
    public AccountVerificationManager(AccountVerificationDao verificationDao, StaffService staffService) {
        this.verificationDao = verificationDao;
        this.staffService = staffService;
    }

    @Override
    public Result createVerification(User user) {
        user.setAccountVerified(false);
        AccountVerification verification = new AccountVerification(0, user, null, false);
        verificationDao.save(verification);
        return new SuccessResult();
    }

    @Override
    public Result verify(AccountVerification verification) {
        AccountVerification verificationToUpdate = verificationDao.getReferenceById(verification.getId());
        Staff reviewer = staffService.get(verification.getReviewer().getId()).getData();

        verificationToUpdate.setReviewer(reviewer);
        verificationToUpdate.setVerified(true);
        verificationToUpdate.getUser().setAccountVerified(true);
        verificationDao.save(verificationToUpdate);
        return new SuccessResult(Messages.ACCOUNT_HAS_BEEN_VERIFIED);
    }
}
