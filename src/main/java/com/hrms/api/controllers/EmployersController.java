package com.hrms.api.controllers;

import com.hrms.business.abstracts.EmployerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("getall")
    DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }

    @GetMapping("getverifiedemployers")
    DataResult<List<Employer>> getVerifiedEmployers(){
        return employerService.getVerifiedEmployers();
    }

    @PostMapping("add")
    Result Add(@RequestBody Employer employer){
        return employerService.add(employer);
    }

}
