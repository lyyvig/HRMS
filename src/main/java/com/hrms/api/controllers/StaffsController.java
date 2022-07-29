package com.hrms.api.controllers;

import com.hrms.business.abstracts.StaffService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staffs")
public class StaffsController {
    StaffService staffService;

    @Autowired
    public StaffsController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("getall")
    DataResult<List<Staff>> getAll(){
        return staffService.getAll();
    }

    @PostMapping("add")
    Result add(@RequestBody Staff staff){
        return staffService.add(staff);
    }
}
