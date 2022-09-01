package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.Result;

public interface UserService {
    Result checkIfEmailExists(String email);
}
