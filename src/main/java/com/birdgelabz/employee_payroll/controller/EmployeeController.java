package com.birdgelabz.employee_payroll.controller;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import com.birdgelabz.employee_payroll.model.EmployeeModel;
import com.birdgelabz.employee_payroll.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @GetMapping({"/","/home","/employee-payroll"})
    public String homePage(){
        return String.format("<h1>%s</h1>","This is the home page for Employee Payroll Application");
    }

    @PostMapping("/create-employee")
    public String createEmployee(@RequestBody EmployeeDTO employee){

        employeeService.saveEmployeeToDatabase(employee);

        return "Employee has been successfully created";
    }

    @GetMapping("/get-employee-by-id/{id}")
    public String getUserById(@PathVariable Long id){

        EmployeeModel employee = employeeService.getUserByIdService(id);

        return "Name: " + employee.getName();

    }

    @GetMapping("/get-employee-by-id")
    public List<EmployeeModel> getAllUsers(){

        List<EmployeeModel> employeeList = new ArrayList<>(employeeService.getAllUsers());

        return employeeList;

    }

    @PutMapping("/update-employee-by-id/{id}")
    public String updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDTO employee){
        employeeService.updateEmployeeByIdService(id,employee);
        return "Your employee has been updated";
    }

    @DeleteMapping("/delete-employee-by-id/{id}")
    public String deleteUserById(@PathVariable Long id){

        employeeService.deleteUserByIdService(id);

        return "User has been deleted";

    }


}
