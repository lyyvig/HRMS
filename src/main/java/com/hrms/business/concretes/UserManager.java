package com.hrms.business.concretes;

import com.hrms.business.abstracts.UserService;
import com.hrms.business.constants.Messages;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Result checkIfEmailExists(String email) {
        if (userDao.existsByEmail(email)) {
            return new ErrorResult(Messages.EMAIL_ALREADY_EXISTS);
        }
        return new SuccessResult();
    }
}
