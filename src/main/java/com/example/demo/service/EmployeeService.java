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

    public String getFormattedEmployee(int empNo) {
        EmployeeDTO emp = getEmployee(empNo);
        return formatEmployeeOutput(emp);
    }

    private String formatEmployeeOutput(EmployeeDTO emp) {
        return String.format("\n\nEmployee   Salary    Commission\n" +
                           "--------   -------   ----------\n" +
                           "%-10s %7.2f    %s\n",
                           emp.getEmpName(),
                           emp.getSalary(),
                           emp.getComm() == null ? "NULL" : String.format("%7.2f", emp.getComm()));
    }
}