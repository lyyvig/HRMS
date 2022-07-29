package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobTitleService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {
    JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<>(jobTitleDao.findAll());
    }

    @Override
    public Result add(JobTitle jobTitle) {
        Result businessResult = BusinessRules.run(
                checkIfJobExists(jobTitle)
        );
        if(businessResult != null){
            return businessResult;
        }
        jobTitleDao.save(jobTitle);
        return new SuccessResult(Messages.JOB_ADDED_SUCCESSFULLY);
    }

    private Result checkIfJobExists(JobTitle job){
        boolean exists = jobTitleDao.existsByTitle(job.getTitle());
        if(exists){
            return new ErrorResult(Messages.JOB_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }

}
