package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Employee getEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public void saveEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		
		Query query = 
				entityManager.createQuery("DELETE FROM Employee e WHERE e.Id=:id");
		
		query.setParameter("id", id);
		
		query.executeUpdate();
		
	}

}
