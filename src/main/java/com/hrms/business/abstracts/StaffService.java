package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Staff;

import java.util.List;

public interface StaffService {
    DataResult<List<Staff>> getAll();
    DataResult<Staff> get(int id);
    Result add(Staff staff);

}
