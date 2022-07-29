package com.hrms.business.concretes;

import com.hrms.business.abstracts.CandidateService;
import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.business.constants.Messages;
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
    private CandidateDao candidateDao;
    private EmailVerificationService emailVerificationService;
    private PersonCheckService personCheckService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, PersonCheckService personCheckService, EmailVerificationService emailVerificationService) {
        this.candidateDao = candidateDao;
        this.personCheckService = personCheckService;
        this.emailVerificationService = emailVerificationService;
    }


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
                checkIfUserEmailAlreadyExists(candidate),
                personCheckService.checkIfRealPerson(new MernisPerson(candidate.getFirstName(), candidate.getLastName(), candidate.getNationalIdentity(), candidate.getBirthYear()))
        );
        if (businessResult != null) {
            return businessResult;
        }

        candidate.getUser().setAccountVerified(true);

        Result verificationResult = emailVerificationService.createVerification(candidate.getUser());

        candidateDao.save(candidate);

        return verificationResult;
    }

    private Result checkIfNationalIdentityAlreadyExists(Candidate candidate) {
        boolean isExists = candidateDao.existsCandidateByNationalIdentity(candidate.getNationalIdentity());
        if (isExists) {
            return new ErrorResult(Messages.NATIONAL_ID_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }

     private Result checkIfUserEmailAlreadyExists(Candidate candidate) {
        boolean isExists = candidateDao.existsByUser_Email(candidate.getUser().getEmail());
        if (isExists) {
            return new ErrorResult(Messages.EMAIL_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }

}
