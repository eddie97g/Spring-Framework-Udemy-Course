package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Employee getEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		return currentSession.get(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("FROM Employee", Employee.class);
		
		return query.getResultList();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.find(Employee.class, id);
		
		currentSession.delete(employee);
	}

}
