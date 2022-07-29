package com.hrms.api.controllers;

import com.hrms.business.abstracts.AccountVerificationService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.AccountVerification;
import com.hrms.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
