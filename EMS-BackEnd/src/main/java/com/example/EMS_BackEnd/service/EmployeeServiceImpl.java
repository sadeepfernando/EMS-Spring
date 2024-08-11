package com.example.EMS_BackEnd.service;

import com.example.EMS_BackEnd.dto.EmployeeDto;
import com.example.EMS_BackEnd.entity.Employee;
import com.example.EMS_BackEnd.mapper.EmployeeMapper;
import com.example.EMS_BackEnd.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
