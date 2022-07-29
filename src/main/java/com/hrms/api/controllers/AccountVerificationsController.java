package com.hrms.api.controllers;

import com.hrms.business.abstracts.AccountVerificationService;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.AccountVerification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accountverifications")
public class AccountVerificationsController {

    AccountVerificationService accountVerificationService;

    public AccountVerificationsController(AccountVerificationService accountVerificationService) {
        this.accountVerificationService = accountVerificationService;
    }

    @PostMapping("verify")
    Result verify(@RequestBody AccountVerification accountVerification){
        return accountVerificationService.verify(accountVerification);
    }
}
