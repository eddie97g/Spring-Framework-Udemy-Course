package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Student student = new Student("Eddie", "Gonzalez", "eddie@yahoo.com");
			
			session.beginTransaction();
			
			session.save(student);
			session.getTransaction().commit();
		}
		
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		finally {
			sessionFactory.close();
		}

	}

}
