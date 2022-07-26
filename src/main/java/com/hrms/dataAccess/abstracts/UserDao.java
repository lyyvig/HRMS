package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}