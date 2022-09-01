package com.hrms.business.concretes;

import com.hrms.business.abstracts.CandidateService;
import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.adapters.email.EmailService;
import com.hrms.core.utilities.adapters.mernis.MernisPerson;
import com.hrms.core.utilities.adapters.mernis.PersonCheckService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    @Autowired
    private CandidateDao candidateDao;
    @Autowired
    private EmailVerificationService emailVerificationService;
    @Autowired
    private PersonCheckService personCheckService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserManager userManager;


    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public DataResult<List<Candidate>> getVerifiedCandidates() {
        return new SuccessDataResult<>(candidateDao.findVerifiedCandidates());
    }

    @Override
    public Result add(Candidate candidate) {
        Result businessResult = BusinessRules.run(
                checkIfNationalIdentityAlreadyExists(candidate),
                userManager.checkIfEmailExists(candidate.getUser().getEmail()),
                personCheckService.checkIfRealPerson(new MernisPerson(candidate.getFirstName(), candidate.getLastName(), candidate.getNationalIdentity(), candidate.getBirthYear()))
        );
        if (businessResult != null) {
            return businessResult;
        }

        candidate.setId(0);
        candidate.getUser().setId(0);

        var emailVerification = emailVerificationService.createVerification();

        candidate.setEmailVerification(emailVerification.getData());

        candidateDao.save(candidate);


        emailService.sendEmail(candidate.getUser().getEmail(), String.valueOf(emailVerification.getData().getCode()), "Email Verification");

        return new SuccessResult(emailVerification.getMessage());
    }

    private Result checkIfNationalIdentityAlreadyExists(Candidate candidate) {
        boolean isExists = candidateDao.existsCandidateByNationalIdentity(candidate.getNationalIdentity());
        if (isExists) {
            return new ErrorResult(Messages.NATIONAL_ID_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }


}
