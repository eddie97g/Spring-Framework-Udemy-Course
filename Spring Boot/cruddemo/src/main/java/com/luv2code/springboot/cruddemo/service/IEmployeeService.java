package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface IEmployeeService {

	public Employee getEmployee(int id);
	public List<Employee> getEmployees();
	public Employee saveEmployee(Employee employee);
	public void deleteEmployee(int id);
}
