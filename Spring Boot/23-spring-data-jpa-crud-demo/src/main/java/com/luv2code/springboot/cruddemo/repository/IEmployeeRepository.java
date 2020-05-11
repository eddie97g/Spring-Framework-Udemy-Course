package com.luv2code.springboot.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
