package com.birdgelabz.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
public @ToString class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public Double salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "startDate should not be null")
    @PastOrPresent(message = "startDate should be past or present's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile pic cannot be empty")
    public String profilePic;

    @NotNull(message = "Department should not be empty")
    public List<String> departments;

//    public EmployeeDTO(String name, Double salary, String gender, LocalDate startDate, String note, String profilePic, List<String> departments) {
//        this.name = name;
//        this.salary = salary;
//        this.gender = gender;
//        this.startDate = startDate;
//        this.note = note;
//        this.profilePic = profilePic;
//        this.departments = departments;
//    }
}
