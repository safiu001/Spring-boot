package com.sd.springdemo.restapidemo.dao;

import com.sd.springdemo.restapidemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateDaoImpl implements EmployeeDao{
    private EntityManager entityManager;

    @Autowired
    public HibernateDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
         Session session = entityManager.unwrap(Session.class);

//         create query
        Query<Employee> query = session.createQuery("from Employee");

//        execute query
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int empId) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, empId);
        return employee;
    }

    @Override
    public void save(Employee emp) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(emp);
    }

    @Override
    public void deleteById(int empId) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, empId);

        session.delete(employee);
    }
}
