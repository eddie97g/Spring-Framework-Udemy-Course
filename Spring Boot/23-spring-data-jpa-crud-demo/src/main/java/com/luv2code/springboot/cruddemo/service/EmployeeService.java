package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> result = this.employeeRepo.findById(id);
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.get();
	}

	@Override
	public List<Employee> getEmployees() {
		return this.employeeRepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		this.employeeRepo.deleteById(id);
	}

}
