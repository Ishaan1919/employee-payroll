package com.birdgelabz.employee_payroll.exceptions;

import com.birdgelabz.employee_payroll.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionalHandler {
    public static final String message = "Exception while processing rest request";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        log.error("Invalid date format",exception);
        ResponseDTO responseDTO = new ResponseDTO(message,"Should have the date in format dd MMM yyyy");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        log.error("Invalid method call");
        ResponseDTO responseDTO = new ResponseDTO(message,"Should have called the proper method");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_GATEWAY);
    }

//    @ExceptionHandler(EmployeePayrollException.class)
//    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
//        log.error("Some error occurred");
//        ResponseDTO responseDTO = new ResponseDTO(message,"There is some employee payroll exception");
//        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_GATEWAY);
//    }
}
