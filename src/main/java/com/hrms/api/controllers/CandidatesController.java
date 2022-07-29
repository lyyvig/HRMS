package com.hrms.api.controllers;

import com.hrms.business.abstracts.CandidateService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("getall")
    public DataResult<List<Candidate>> getAll(){
        return candidateService.getAll();
    }

    @GetMapping("getallverified")
    public DataResult<List<Candidate>> getAllVerified(){
        return candidateService.getVerifiedCandidates();
    }

    @PostMapping("add")
    public Result add(@RequestBody Candidate candidate){
        return  candidateService.add(candidate);
    }

}
