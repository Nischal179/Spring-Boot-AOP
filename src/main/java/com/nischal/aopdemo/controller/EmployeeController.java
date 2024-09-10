package com.nischal.aopdemo.controller;

import com.nischal.aopdemo.dto.EmployeeResponseDTO;
import com.nischal.aopdemo.entity.Employee;
import com.nischal.aopdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> fetchAllEmployee() {
        return new ResponseEntity<List<EmployeeResponseDTO>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
}
