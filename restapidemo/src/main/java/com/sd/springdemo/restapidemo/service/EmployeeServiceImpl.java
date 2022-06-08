package com.sd.springdemo.restapidemo.service;

import com.sd.springdemo.restapidemo.dao.EmployeeDao;
import com.sd.springdemo.restapidemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier(value="daoJpaImpl") EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int empId) {
        return employeeDao.findById(empId);
    }

    @Override
    @Transactional
    public void save(Employee emp) {
        employeeDao.save(emp);
    }

    @Override
    @Transactional
    public void deleteById(int empId) {
        employeeDao.deleteById(empId);
    }
}
