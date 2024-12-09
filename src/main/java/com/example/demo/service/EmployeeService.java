package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;

@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO getEmployee(int empNo) {
        return employeeMapper.findByEmpNo(empNo);
    }
}