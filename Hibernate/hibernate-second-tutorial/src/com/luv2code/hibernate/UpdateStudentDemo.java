package com.luv2code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
//			session.createQuery("UPDATE Student set email='generic@gmail.com'").executeUpdate();
			
			Student student = session.get(Student.class, 1);
			student.setEmail("eddie@yahoo.com");
			System.out.println(student);
			
//			for(Student student : students) {
//				System.out.println(student);
//			}
			
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
