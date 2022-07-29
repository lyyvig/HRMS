package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobOffer;

import java.util.List;

public interface JobOfferService {
    DataResult<List<JobOffer>> getAll();
    DataResult<List<JobOffer>> getActiveJobs();
    Result add(JobOffer job);
    Result deactivateJob(JobOffer job);
}
