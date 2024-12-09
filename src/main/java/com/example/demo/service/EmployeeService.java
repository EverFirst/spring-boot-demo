package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.exception.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO getEmployee(int empNo) {
        EmployeeDTO employee = employeeMapper.findByEmpNo(empNo);
        if (employee == null) {
            throw new EntityNotFoundException("사번 [" + empNo + "] 존재하지 않는 사번입니다.");
        }
        return employee;
    }
}