package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobTitleService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobTitle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
    JobTitleService jobTitleService;

    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("getall")
    DataResult<List<JobTitle>> getAll(){
        return jobTitleService.getAll();
    }

    @PostMapping("add")
    Result add(@RequestBody JobTitle jobTitle){
        return jobTitleService.add(jobTitle);
    }



}
