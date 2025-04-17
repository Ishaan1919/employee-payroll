package com.birdgelabz.employee_payroll.service;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import com.birdgelabz.employee_payroll.dto.ResponseDTO;
import com.birdgelabz.employee_payroll.model.EmployeeModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    public ResponseEntity<EmployeeModel> saveEmployeeToDatabase(EmployeeDTO employee);
    public EmployeeModel getUserByIdService(Long id);
    public List<EmployeeModel> getAllUsers();
    public ResponseDTO updateEmployeeByIdService(Long id, EmployeeDTO employee);
    public void deleteUserByIdService(Long id);

}
