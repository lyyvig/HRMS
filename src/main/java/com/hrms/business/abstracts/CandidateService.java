package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Candidate;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface CandidateService {
    DataResult<List<Candidate>> getAll();

    DataResult<List<Candidate>> getVerifiedCandidates();

    Result add(@Valid Candidate candidate);
}
