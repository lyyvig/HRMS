package com.hrms.business.concretes;

import com.hrms.business.abstracts.AccountVerificationService;
import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.business.abstracts.EmployerService;
import com.hrms.business.constants.EmailAddresses;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.adapters.email.EmailService;
import com.hrms.core.utilities.adapters.mernis.MernisPerson;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailService emailService;
    private EmailVerificationService emailVerificationService;
    private AccountVerificationService accountVerificationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService, EmailVerificationService emailVerificationService, AccountVerificationService accountVerificationService) {
        this.employerDao = employerDao;
        this.emailService = emailService;
        this.emailVerificationService = emailVerificationService;
        this.accountVerificationService = accountVerificationService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll());
    }

    @Override
    public DataResult<List<Employer>> getVerifiedEmployers() {
        return new SuccessDataResult<>(employerDao.findVerifiedEmployers());
    }

    @Override
    public Result add(Employer employer) {
        Result businessResult = BusinessRules.run(
                checkIfUserEmailAlreadyExists(employer)
        );
        if(businessResult!=null){
            return businessResult;
        }

        Result emailVerificationResult = emailVerificationService.createVerification(employer.getUser());
        if(!emailVerificationResult.isSuccess()){
            return emailVerificationResult;
        }

        Result accountVerificationResult = accountVerificationService.createVerification(employer.getUser());
        if(!accountVerificationResult.isSuccess()) {
            return accountVerificationResult;
        }


        employerDao.save(employer);
        return emailVerificationResult;
    }

    private Result checkIfUserEmailAlreadyExists(Employer employer){
        boolean isExists = employerDao.existsByUser_Email(employer.getUser().getEmail());
        if(isExists){
            return new ErrorResult(Messages.EMAIL_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }
}
