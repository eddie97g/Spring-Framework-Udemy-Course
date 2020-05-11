package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface IEmployeeDAO {

	public Employee getEmployee(int id);
	public List<Employee> findAll();
	public void saveEmployee(Employee employee);
	public void deleteEmployee(int id);
}
