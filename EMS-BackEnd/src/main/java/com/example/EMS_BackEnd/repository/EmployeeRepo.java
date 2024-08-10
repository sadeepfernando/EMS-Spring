package com.example.EMS_BackEnd.repository;

import com.example.EMS_BackEnd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
