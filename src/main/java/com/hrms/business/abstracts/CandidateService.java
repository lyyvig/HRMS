package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Candidate;
import com.hrms.entities.concretes.EmailVerification;

import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    DataResult<List<Candidate>> getVerifiedCandidates();
    Result add(Candidate candidate);
}
