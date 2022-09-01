package com.hrms.core.crossCuttingConcerns.validations.MultiPartFile;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultiPartFileValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiPartFileContent {
    String message() default "Invalid image format";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};
    String[] allowedMimeTypes();
    boolean mustHaveFileExtension() default false;


}
