package com.birdgelabz.employee_payroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Employee;

    private String name;
    private Double salary;

    public EmployeeModel(){

    }

    public EmployeeModel(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Long getEmployee() {
        return Employee;
    }

    public void setEmployee(Long employee) {
        Employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
