package com.sd.springdemo.restapidemo.dao;

import com.sd.springdemo.restapidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
