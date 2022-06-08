package com.sd.springdemo.restapidemo.dao;

import com.sd.springdemo.restapidemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int empId);
    void save(Employee emp);
    void deleteById(int empId);
}
