package com.hrms.business.concretes;

import com.hrms.business.abstracts.ResumeService;
import com.hrms.business.constants.FilePaths;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.FileUtils;
import com.hrms.core.utilities.adapters.media.FileService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.*;
import com.hrms.dataAccess.abstracts.ResumeDao;
import com.hrms.entities.concretes.Image;
import com.hrms.entities.concretes.resume.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ResumeManager implements ResumeService {
    @Autowired
    ResumeDao resumeDao;
    @Autowired
    FileService fileService;

    @Override
    public Result add(Resume resume, MultipartFile resumeImage) {
        Result businessResult = BusinessRules.run(
                checkIfCandidatesResumeAlreadyExists(resume)
        );
        if (businessResult != null) {
            return businessResult;
        }
        String fileExtension = FileUtils.getFileExtension(resumeImage.getOriginalFilename());
        String filePath = FilePaths.RESUME_IMAGES + UUID.randomUUID() + "." + fileExtension;
        var uploadResult = fileService.uploadFile(resumeImage, filePath);
        if (!uploadResult.isSuccess()) {
            return uploadResult;
        }

        resume.setId(0);
        resume.setImage(new Image(0, uploadResult.getData(), filePath));

        resumeDao.save(resume);
        return new SuccessResult(Messages.RESUME_SAVED);
    }

    @Override
    public DataResult<Resume> getCandidateResume(int candidateId) {
        return new SuccessDataResult<>(resumeDao.findByCandidate_Id(candidateId));
    }

    private Result checkIfCandidatesResumeAlreadyExists(Resume resume) {
        boolean resumeExists = resumeDao.existsByCandidate_Id(resume.getId());
        if (resumeExists) {
            return new ErrorResult(Messages.RESUME_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }
}
