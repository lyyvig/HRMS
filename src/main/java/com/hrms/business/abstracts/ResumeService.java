package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.resume.Resume;
import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {
    Result add(Resume resume, MultipartFile resumeImage);
    Result add(String resumeJson, MultipartFile resumeImage);
    DataResult<Resume> getCandidateResume(int candidateId);
}
