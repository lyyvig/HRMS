package com.hrms.core.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = {ValidationException.class})
    protected Object handleValidationError(ValidationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        var e = (ConstraintViolationException) ex;
        e.getConstraintViolations().forEach((error) -> {
            var field = error.getPropertyPath().toString().split("\\.");
            String fieldName = field[field.length - 1];
            String errorMessage = error.getMessage();
            errors.add(fieldName + " " + errorMessage);
        });
        return errors;
    }
}
