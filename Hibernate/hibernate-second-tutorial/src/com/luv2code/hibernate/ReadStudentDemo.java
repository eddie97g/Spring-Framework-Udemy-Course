package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Student student = new Student("Daffy", "Duck", "daffy@yahoo.com");
			
			session.beginTransaction();
			
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Saved student with ID: " + student.getId());
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student getStudent = session.get(Student.class, student.getId());
			System.out.println("Retrieved student: " + getStudent.getFirstName());
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
