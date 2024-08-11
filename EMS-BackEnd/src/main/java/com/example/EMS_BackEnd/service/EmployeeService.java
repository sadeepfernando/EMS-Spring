package com.example.EMS_BackEnd.service;

import com.example.EMS_BackEnd.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
}
