package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface EmployerService {
    DataResult<List<Employer>> getAll();

    DataResult<List<Employer>> getVerifiedEmployers();

    Result add(@Valid Employer employer);
}
