package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.AccountVerification;
import com.hrms.entities.concretes.EmailVerification;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.Staff;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<List<Employer>> getVerifiedEmployers();
    Result add(Employer employer);
}
