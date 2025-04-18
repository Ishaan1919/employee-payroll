package com.birdgelabz.employee_payroll.model;

import com.birdgelabz.employee_payroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Getter @Setter
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "name")
    private String name;


    private Double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;


    public EmployeeModel(){}

    public EmployeeModel(EmployeeDTO employeeDTO){
        this.updateEmployeeModel(employeeDTO);
    }

    public void updateEmployeeModel(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
        this.gender = employeeDTO.gender;
        this.note = employeeDTO.note;
        this.startDate = employeeDTO.startDate;
        this.profilePic = employeeDTO.profilePic;
        this.departments = new ArrayList<>(employeeDTO.departments);
    }

}
