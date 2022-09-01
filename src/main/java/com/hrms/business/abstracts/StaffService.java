package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Staff;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface StaffService {
    DataResult<List<Staff>> getAll();

    DataResult<Staff> get(int id);

    Result add(@Valid Staff staff);

}
