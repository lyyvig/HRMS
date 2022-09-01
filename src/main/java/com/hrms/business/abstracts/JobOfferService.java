package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobOffer;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface JobOfferService {
    DataResult<List<JobOffer>> getAll();

    DataResult<List<JobOffer>> getActiveJobs();

    Result add(@Valid JobOffer job);

    Result deactivateJob(int jobId);
}
