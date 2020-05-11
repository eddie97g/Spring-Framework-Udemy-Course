package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.IEmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public Employee getEmployee(int id) {
		return this.employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return this.employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		return this.employeeDAO.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		this.employeeDAO.deleteEmployee(id);
	}

}
