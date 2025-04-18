package com.birdgelabz.employee_payroll.service;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import com.birdgelabz.employee_payroll.dto.ResponseDTO;
import com.birdgelabz.employee_payroll.model.EmployeeModel;
import com.birdgelabz.employee_payroll.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    public ResponseEntity<EmployeeModel> saveEmployeeToDatabase(EmployeeDTO employee){

        EmployeeModel newEmployee = new EmployeeModel(employee);
        employeeRepository.save(newEmployee);

        return new ResponseEntity<EmployeeModel> (newEmployee, HttpStatus.CREATED);
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

        if(updateEmployee.name!=null) {
            employeeExist.setName(updateEmployee.name);
        }
        if(updateEmployee.salary!=null){
                employeeExist.setSalary(updateEmployee.salary);
        }
        if(updateEmployee.gender!=null) {
            employeeExist.setGender(updateEmployee.gender);
        }
        if(updateEmployee.startDate!=null){
                employeeExist.setStartDate(updateEmployee.startDate);
        }
        if(updateEmployee.note!=null) {
            employeeExist.setNote(updateEmployee.note);
        }
        if(updateEmployee.profilePic!=null){
                employeeExist.setProfilePic(updateEmployee.profilePic);
        }
        if(updateEmployee.departments!=null){
            employeeExist.setDepartments(updateEmployee.departments);
        }


        employeeRepository.save(employeeExist);

        return new ResponseDTO("User has been updated", HttpStatus.OK);
    }

    public void deleteUserByIdService(Long id){
        employeeRepository.deleteById(id);
    }


}
