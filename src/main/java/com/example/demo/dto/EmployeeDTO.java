package com.example.demo.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private int empNo;
    private String empName;
    private double salary;
    private Double comm;  
    private Integer deptno;
}