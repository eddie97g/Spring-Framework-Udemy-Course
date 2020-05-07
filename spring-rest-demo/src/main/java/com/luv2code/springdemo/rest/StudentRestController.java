package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		this.students = new ArrayList<>();
		
		students.add(new Student("Mary", "Beth"));
		students.add(new Student("John", "Wick"));
		students.add(new Student("Holden", "Caulfield"));
	}
	
	@GetMapping("students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable int id) {
		if (id < 0 || id >= this.students.size()) {
			throw new StudentNotFoundException("Student Not Found");
		}
		return students.get(id);
	}

}
