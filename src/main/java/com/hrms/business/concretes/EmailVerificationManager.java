package com.hrms.business.concretes;

import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.adapters.email.EmailService;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.EmailVerificationDao;
import com.hrms.entities.concretes.EmailVerification;
import com.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailVerificationManager implements EmailVerificationService {
    EmailVerificationDao verificationDao;
    EmailService emailService;

    @Autowired
    public EmailVerificationManager(EmailVerificationDao verificationDao, EmailService emailService) {
        this.verificationDao = verificationDao;
        this.emailService = emailService;
    }

    @Override
    public DataResult<EmailVerification> createVerification(User user) {
        Random r = new Random();
        EmailVerification verification = new EmailVerification(0, r.nextInt(9999), false);
        verificationDao.save(verification);
        emailService.sendEmail(user.getEmail(), String.valueOf(verification.getCode()), "Email Verification");
        return new SuccessDataResult<>(verification, Messages.CHECK_YOUR_EMAILS_AND_VERIFY_YOUR_ACCOUNT);
    }

    @Override
    public Result verify(EmailVerification verification) {
        EmailVerification verificationToUpdate = verificationDao.getReferenceById(verification.getId());
        if(verificationToUpdate.getCode() == verification.getCode()){
            verificationToUpdate.setVerified(true);
            verificationDao.save(verificationToUpdate);
            return new SuccessResult(Messages.EMAIL_VERIFIED);
        }
        return new ErrorResult(Messages.WRONG_CODE);
    }
}
