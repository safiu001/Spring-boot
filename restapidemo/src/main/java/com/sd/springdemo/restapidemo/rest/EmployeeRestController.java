package com.sd.springdemo.restapidemo.rest;


import com.sd.springdemo.restapidemo.dto.EmployeeCreationDTO;
import com.sd.springdemo.restapidemo.entity.Employee;
import com.sd.springdemo.restapidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

//    constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.findAll();

        return employees;
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployee(@PathVariable int empId){
        Employee employee = employeeService.findById(empId);

        if(employee == null){
            throw new RuntimeException("Employee Id not Found "+empId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public EmployeeCreationDTO addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employeeToDTO(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        Employee employee = employeeService.findById(empId);

        if(employee == null){
            throw new RuntimeException("Employee not Found "+ empId);
        }

        employeeService.deleteById(empId);

        return "Deleted Employee with Id - "+empId;
    }


    private EmployeeCreationDTO employeeToDTO(Employee employee){
        EmployeeCreationDTO employeeDTO = new EmployeeCreationDTO();

        employeeDTO.setEmpId(employee.getId());

        employeeDTO.setMessage("Employee with "+ employee.getId() + " created successfully");

        employeeDTO.setStatusCode(HttpStatus.CREATED.value());

        return employeeDTO;
    }
}
