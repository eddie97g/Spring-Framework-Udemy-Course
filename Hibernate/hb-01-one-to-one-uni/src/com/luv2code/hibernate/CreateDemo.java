package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Nelson", "Rushton", "nelson.rushton@ttu.edu");
			
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/user/nelsonrushton", "creating languages");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
//			Instructor instructor = session.get(Instructor.class, 1);
//			session.delete(instructor);
//			session.save(instructor);
			
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
