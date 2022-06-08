package com.sd.springdemo.restapidemo.service;

import com.sd.springdemo.restapidemo.dao.EmployeeRepository;
import com.sd.springdemo.restapidemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int empId) {
        Optional<Employee> res = employeeRepository.findById(empId);

        Employee employee = null;

        if(res.isPresent()){
            employee = res.get();
        }else{throw new RuntimeException("Employee not found "+ empId);}
        return employee;
    }

    @Override
    public void save(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void deleteById(int empId) {
        employeeRepository.deleteById(empId);
    }
}
