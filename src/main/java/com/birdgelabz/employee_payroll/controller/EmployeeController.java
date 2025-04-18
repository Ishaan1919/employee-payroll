package com.birdgelabz.employee_payroll.controller;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import com.birdgelabz.employee_payroll.dto.ResponseDTO;
import com.birdgelabz.employee_payroll.model.EmployeeModel;
import com.birdgelabz.employee_payroll.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @GetMapping({"/","/home","/employee-payroll"})
    public String homePage(){
        return String.format("<h1>%s</h1>","This is the home page for Employee Payroll Application");
    }

    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeModel> createEmployee(@Valid @RequestBody EmployeeDTO employee){

        return employeeService.saveEmployeeToDatabase(employee);

    }

    @GetMapping("/get-employee-by-id/{id}")
    public String getUserById(@PathVariable Long id){

        EmployeeModel employee = employeeService.getUserByIdService(id);

        return "Name: ";

    }

    @GetMapping("/get-employee-by-id")
    public List<EmployeeModel> getAllUsers(){

        List<EmployeeModel> employeeList = new ArrayList<>(employeeService.getAllUsers());

        return employeeList;

    }

    @PutMapping("/update-employee-by-id/{id}")
    public ResponseDTO updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDTO employee){
        return employeeService.updateEmployeeByIdService(id,employee);
    }

    @DeleteMapping("/delete-employee-by-id/{id}")
    public String deleteUserById(@PathVariable Long id){

        employeeService.deleteUserByIdService(id);
        return "User has been deleted";

    }


}
