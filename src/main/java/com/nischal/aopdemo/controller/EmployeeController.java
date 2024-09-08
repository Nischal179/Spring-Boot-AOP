package com.nischal.aopdemo.controller;

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
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmps(), HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
}
