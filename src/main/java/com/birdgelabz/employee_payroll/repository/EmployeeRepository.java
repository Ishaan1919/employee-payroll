package com.birdgelabz.employee_payroll.repository;

import com.birdgelabz.employee_payroll.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {
}
