package com.hrms.core.crossCuttingConcerns.validations.MultiPartFile;

import com.hrms.core.utilities.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class MultiPartFileValidator implements ConstraintValidator<MultiPartFileContent, MultipartFile> {
    private String[] formats;
    private boolean mustHaveFileExtension;

    @Override
    public void initialize(MultiPartFileContent constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        formats = constraintAnnotation.allowedMimeTypes();
        mustHaveFileExtension = constraintAnnotation.mustHaveFileExtension();
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        if(mustHaveFileExtension && FileUtils.getFileExtension(value.getOriginalFilename()) == null){
            return false;
        }

        if (value == null)
            return false;

        String content = value.getContentType();
        if (content == null)
            return false;



        return Arrays.stream(formats).anyMatch(s -> content.contains(s));
    }
}
