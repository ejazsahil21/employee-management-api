package com.api.repository;

import com.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByMobile(String mobile);
    boolean existsByEmailId(String emailId);
}
