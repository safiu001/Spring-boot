package com.sd.springdemo.restapidemo.dao;

import com.sd.springdemo.restapidemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoJpaImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public DaoJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int empId) {
        Employee employee = entityManager.find(Employee.class, empId);
        return employee;
    }

    @Override
    public void save(Employee emp) {
        Employee employee = entityManager.merge(emp);

        emp.setId(employee.getId());
    }

    @Override
    public void deleteById(int empId) {
        Query query = entityManager.createQuery("delete from Employee where id=:empId");

        query.setParameter("empId", empId);

        query.executeUpdate();
    }
}
