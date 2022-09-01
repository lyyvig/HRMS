package com.hrms.business.concretes;

import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.adapters.email.EmailService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.EmailVerificationDao;
import com.hrms.entities.concretes.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailVerificationManager implements EmailVerificationService {
    @Autowired
    EmailVerificationDao verificationDao;
    @Autowired
    EmailService emailService;

    @Override
    public DataResult<EmailVerification> createVerification() {
        Random r = new Random();
        EmailVerification verification = new EmailVerification(0, r.nextInt(9999), false);
        return new SuccessDataResult<>(verification);
    }

    @Override
    public Result verify(EmailVerification verification) {
        EmailVerification verificationToUpdate = verificationDao.getReferenceById(verification.getId());
        if (verificationToUpdate.getCode() == verification.getCode()) {
            verificationToUpdate.setVerified(true);
            verificationDao.save(verificationToUpdate);
            return new SuccessResult(Messages.EMAIL_VERIFIED);
        }
        return new ErrorResult(Messages.WRONG_CODE);
    }
}
