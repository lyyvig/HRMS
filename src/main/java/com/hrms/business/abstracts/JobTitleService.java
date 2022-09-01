package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobTitle;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();

    Result add(@Valid JobTitle jobTitle);
}
