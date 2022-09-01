package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobOfferService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobOfferDao;
import com.hrms.entities.concretes.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferManager implements JobOfferService {
    @Autowired
    JobOfferDao jobDao;

    @Override
    public DataResult<List<JobOffer>> getAll() {
        return new SuccessDataResult<>(jobDao.findAll());
    }

    @Override
    public DataResult<List<JobOffer>> getActiveJobs() {
        return new SuccessDataResult<>(jobDao.findByActiveIsTrue());
    }

    @Override
    public Result add(JobOffer job) {
        jobDao.save(job);
        return new SuccessResult();
    }

    @Override
    public Result deactivateJob(int jobId) {
        JobOffer jobToUpdate = jobDao.getReferenceById(jobId);
        jobToUpdate.setActive(false);
        jobDao.save(jobToUpdate);
        return new SuccessResult();
    }
}
