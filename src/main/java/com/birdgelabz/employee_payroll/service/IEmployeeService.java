package com.birdgelabz.employee_payroll.service;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import com.birdgelabz.employee_payroll.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
    public boolean saveEmployeeToDatabase(EmployeeDTO employee);
    public EmployeeModel getUserByIdService(Long id);
    public List<EmployeeModel> getAllUsers();
    public EmployeeModel updateEmployeeByIdService(Long id, EmployeeDTO employee);
    public void deleteUserByIdService(Long id);

}
