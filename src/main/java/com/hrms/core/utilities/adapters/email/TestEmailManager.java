package com.hrms.core.utilities.adapters.email;

import com.hrms.core.utilities.constants.CoreMessages;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class TestEmailManager implements EmailService{
    @Override
    public Result sendEmail(String emailTo, String subject, String message) {
        return new SuccessResult(CoreMessages.EMAIL_SENT);
    }
}
