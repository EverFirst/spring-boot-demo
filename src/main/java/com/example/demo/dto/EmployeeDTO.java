package com.example.demo.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private int empNo;
    private String empName;
    private double salary;
    private Double comm;  // null 가능하므로 Double
}