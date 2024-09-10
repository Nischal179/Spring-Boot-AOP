package com.nischal.aopdemo.dto;

public class EmployeeResponseDTO {

    private String name;

    public EmployeeResponseDTO() {

    }

    public EmployeeResponseDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeResponseDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
