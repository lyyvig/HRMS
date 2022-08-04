package com.hrms.api.controllers;

import com.hrms.business.abstracts.ResumeService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.resume.Resume;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
    ResumeService resumeService;

    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("getCandidateResume")
    DataResult<Resume> getCandidateResume(@RequestParam int candidateId){
        return resumeService.getCandidateResume(candidateId);

    }

    @PostMapping(value = "add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    Result add(@RequestPart String resume, @RequestPart MultipartFile file){
        return resumeService.add(resume, file);
    }
}
