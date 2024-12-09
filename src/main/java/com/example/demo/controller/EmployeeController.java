package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{empNo}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int empNo) {
        return ResponseEntity.ok(employeeService.getEmployee(empNo));
    }

    @GetMapping("/{empNo}/formatted")
    public ResponseEntity<String> getFormattedEmployee(@PathVariable int empNo) {
        return ResponseEntity.ok(employeeService.getFormattedEmployee(empNo));
    }
}