package com.sd.springdemo.restapidemo.service;

import com.sd.springdemo.restapidemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int empId);

    void save(Employee emp);

    void deleteById(int empId);
}
