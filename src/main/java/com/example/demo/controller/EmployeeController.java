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

    @PostMapping("/dept")
    public ResponseEntity<Void> insertEmployeeWithDept(@RequestBody EmployeeDTO employee) {
        employeeService.insertEmployeeWithDept(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/dept")
    public ResponseEntity<Void> deleteEmployeeByDepts( 
        @RequestParam("deptNo1") int deptNo1,
        @RequestParam("deptNo2") int deptNo2) {
        employeeService.deleteEmployeeByDepts(deptNo1, deptNo2);
        return ResponseEntity.ok().build();
    }
}