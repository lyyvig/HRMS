package com.hrms.core.utilities.adapters.mernis;

import com.hrms.core.utilities.results.Result;

public interface PersonCheckService {
    Result checkIfRealPerson(MernisPerson mernisPerson);
}
