package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {
    EmployeeDTO findByEmpNo(int empNo);
    void insertEmployeeWithDept(EmployeeDTO employee);
    void deleteEmployeeByDepts(int deptNo1, int deptNo2);
}