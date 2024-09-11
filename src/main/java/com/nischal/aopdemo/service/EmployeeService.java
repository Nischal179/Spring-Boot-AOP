package com.nischal.aopdemo.service;

import com.nischal.aopdemo.dto.EmployeeResponseDTO;
import com.nischal.aopdemo.entity.Employee;
import com.nischal.aopdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employee = employeeRepo.findAll();
        return employee.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Employee addEmployee(Employee employee) throws Exception {

        if (employee.getName().length() > 10) {
            throw new  Exception("Sorry please reduce size of your name");
        }

        return employeeRepo.save(employee);
    }

    private EmployeeResponseDTO convertToDto(Employee employee) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setName(employee.getName());
        return employeeResponseDTO;
    }
}
