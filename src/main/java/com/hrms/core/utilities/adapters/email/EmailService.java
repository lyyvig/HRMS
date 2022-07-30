package com.hrms.core.utilities.adapters.email;


import com.hrms.core.utilities.results.Result;


public interface EmailService {
    Result sendEmail(String emailTo, String subject, String message);
}
