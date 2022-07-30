package com.hrms.core.utilities.adapters.email;

import com.hrms.core.utilities.constants.CoreMessages;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
public class SpringBootEmailManager implements EmailService{

    JavaMailSender emailSender;

    @Autowired
    public SpringBootEmailManager(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public Result sendEmail(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        try {
            emailSender.send(mailMessage);
            return new SuccessResult(CoreMessages.EMAIL_SENT);
        }
        catch (MailException e){
            return new ErrorResult(CoreMessages.FAILED_TO_SEND_THE_EMAIL);
        }
    }


}
