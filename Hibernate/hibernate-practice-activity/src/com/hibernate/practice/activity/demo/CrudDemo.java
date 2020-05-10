package com.hibernate.practice.activity.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.practice.activity.entity.Employee;

public class CrudDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Employee.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
											
		try {
//			CreateEmployees(session);
//			QueryEmployeesByCompany(session);
//			GetEmployeeById(session);
//			UpdateEmployee(session);
			DeleteEmployee(session);
		}
		
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		finally {
			sessionFactory.close();
		}

	}
	
	public static void CreateEmployees(Session session) {
		System.out.println("Creating employees");
		Employee employee1 = new Employee("Eddie", "Gonzalez", "Southwest Airlines");
		Employee employee2 = new Employee("Jeff", "Bezos", "Amazon");
		Employee employee3 = new Employee("Bill", "Gates", "Microsoft");
		session.beginTransaction();
		
		System.out.println("Saving employees");
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		
		session.getTransaction().commit();
		System.out.println("Saved employees to DB");
		
	}
	
	public static List<Employee> QueryEmployeesByCompany(Session session) {
		session.beginTransaction();
		
		List<Employee> employees = session.createQuery("FROM Employee e WHERE e.company='Amazon'").getResultList();
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
		session.getTransaction().commit();
		
		return employees;
	}
	
	public static Employee GetEmployeeById(Session session) {
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee);
		
		session.getTransaction().commit();
		
		return employee;
	}
	
	public static void UpdateEmployee(Session session) {
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, 1);
		
		employee.setCompany("JPMorgan Chase & Co.");
		
		session.getTransaction().commit();
		System.out.println(employee);
	}
	
	public static void DeleteEmployee(Session session) {
		session.beginTransaction();
		
		session.createQuery("DELETE Employee e WHERE e.Id=1").executeUpdate();
		
		session.getTransaction().commit();
	}

}
