package com.hrms.api.controllers;


import com.hrms.business.abstracts.EmailVerificationService;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emailverifications")
public class EmailVerificationsController {
    EmailVerificationService emailVerificationService;

    @Autowired
    public EmailVerificationsController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("verify")
    Result verify(EmailVerification verification){
        return emailVerificationService.verify(verification);
    }
}
