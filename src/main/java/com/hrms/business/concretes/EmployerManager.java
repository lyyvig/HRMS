package com.hrms.business.concretes;

import com.hrms.business.abstracts.AccountVerificationService;
import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.business.abstracts.EmployerService;
import com.hrms.core.utilities.adapters.email.EmailService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    @Autowired
    private EmployerDao employerDao;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailVerificationService emailVerificationService;
    @Autowired
    private AccountVerificationService accountVerificationService;
    @Autowired
    private UserManager userManager;

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
                userManager.checkIfEmailExists(employer.getUser().getEmail())
        );
        if (businessResult != null) {
            return businessResult;
        }

        employer.setId(0);
        employer.getUser().setId(0);

        var accountVerificationResult = accountVerificationService.createVerification();

        employer.setAccountVerification(accountVerificationResult.getData());

        var emailVerificationResult = emailVerificationService.createVerification();

        employer.setEmailVerification(emailVerificationResult.getData());

        employerDao.save(employer);

        emailService.sendEmail(employer.getUser().getEmail(), "Email Verification", String.valueOf(emailVerificationResult.getData().getCode()));

        return new SuccessResult(emailVerificationResult.getMessage());

    }

}
