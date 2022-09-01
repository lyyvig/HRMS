package com.hrms.business.concretes;

import com.hrms.business.abstracts.StaffService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.StaffDao;
import com.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {
    @Autowired
    StaffDao staffDao;
    @Autowired
    private UserManager userManager;

    @Override
    public DataResult<List<Staff>> getAll() {
        return new SuccessDataResult<>(staffDao.findAll());
    }

    @Override
    public DataResult<Staff> get(int id) {
        return new SuccessDataResult<>(staffDao.getReferenceById(id));
    }

    @Override
    public Result add(Staff staff) {
        Result businessResult = BusinessRules.run(
                userManager.checkIfEmailExists(staff.getUser().getEmail())
        );
        if (businessResult != null) {
            return businessResult;
        }
        staffDao.save(staff);
        return new SuccessResult();
    }
}
