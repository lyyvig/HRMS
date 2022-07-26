package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

}