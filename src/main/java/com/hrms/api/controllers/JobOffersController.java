package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobOfferService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobOffers")
public class JobOffersController {
    JobOfferService jobOfferService;

    @Autowired
    public JobOffersController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping("getAll")
    DataResult<List<JobOffer>> getAll(){
        return jobOfferService.getAll();
    }

    @GetMapping("getActiveJobs")
    DataResult<List<JobOffer>> getActiveJobs(){
        return jobOfferService.getActiveJobs();
    }

    @PostMapping("add")
    Result add(@RequestBody JobOffer jobOffer){
        return jobOfferService.add(jobOffer);
    }

    @PostMapping("deactivateJob")
    Result deactivateJob(@RequestBody JobOffer jobOffer){
        return jobOfferService.deactivateJob(jobOffer);
    }

}
