package com.hrms.business.abstracts;

import com.hrms.core.crossCuttingConcerns.validations.MultiPartFile.MultiPartFileContent;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.resume.Resume;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Validated
public interface ResumeService {
    Result add(@Valid Resume resume, @Valid @MultiPartFileContent(allowedMimeTypes = {"image/jpeg", "image/png"}, mustHaveFileExtension = true) MultipartFile resumeImage);

    DataResult<Resume> getCandidateResume(int candidateId);
}
