package com.example.EMS_BackEnd.service;

import com.example.EMS_BackEnd.dto.EmployeeDto;
import com.example.EMS_BackEnd.entity.Employee;
import com.example.EMS_BackEnd.exception.ServiceNotFoundException;
import com.example.EMS_BackEnd.mapper.EmployeeMapper;
import com.example.EMS_BackEnd.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepo
                .findById(id)
                .orElseThrow(()-> new ServiceNotFoundException("There is no such a Employee Id"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();

        return employees
                .stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepo
                .findById(id)
                .orElseThrow(()-> new ServiceNotFoundException("There is no such a Employee"));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmp = employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmp);
    }

    @Override
    public void deleteEmployee(Long id) {
       Employee employee = employeeRepo.findById(id)
               .orElseThrow(()-> new ServiceNotFoundException("THere is no such an Employee to delete"));
       employeeRepo.deleteById(id);
    }
}
