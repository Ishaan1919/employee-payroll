package com.birdgelabz.employee_payroll.service;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import com.birdgelabz.employee_payroll.dto.ResponseDTO;
import com.birdgelabz.employee_payroll.model.EmployeeModel;
import com.birdgelabz.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    public ResponseEntity<EmployeeModel> saveEmployeeToDatabase(EmployeeDTO employee){

        EmployeeModel newEmployee = new EmployeeModel(employee.getName(),employee.getSalary());
        employeeRepository.save(newEmployee);

        if(newEmployee.getName()!=null && newEmployee.getSalary()!=null){
            return new ResponseEntity<EmployeeModel> (newEmployee, HttpStatus.CREATED);
        }
        return null;
    }

    public EmployeeModel getUserByIdService(Long id){
        Optional<EmployeeModel> employee = employeeRepository.findById(id);

        if(employee == null){
            return null;
        }

        EmployeeModel existingEmployee = employee.get();
        return existingEmployee;
    }

    public List<EmployeeModel> getAllUsers(){
        return employeeRepository.findAll();
    }

    public ResponseDTO updateEmployeeByIdService(Long id, EmployeeDTO updateEmployee){
        Optional<EmployeeModel> existingEmployee = employeeRepository.findById(id);

        if(existingEmployee.isEmpty()){
            return null;
        }

        EmployeeModel employeeExist = existingEmployee.get();

        if(updateEmployee.getName()!=null)
        employeeExist.setName(updateEmployee.getName());
        if(updateEmployee.getSalary()!=null)
        employeeExist.setSalary(updateEmployee.getSalary());
        employeeRepository.save(employeeExist);

        return new ResponseDTO("User has been updated", HttpStatus.OK);
    }

    public void deleteUserByIdService(Long id){
        employeeRepository.deleteById(id);
    }


}
