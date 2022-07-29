package com.hrms.core.utilities.adapters.mernis;

import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class TestPersonCheckManager implements PersonCheckService {
    @Override
    public Result checkIfRealPerson(MernisPerson mernisPerson) {
        return new SuccessResult();
    }
}
