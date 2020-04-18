package com.luv2code.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Query<Instructor> query = session.createQuery("FROM Instructor i JOIN FETCH"
														+ " i.courses WHERE i.id=1", Instructor.class);
			
			Instructor instructor = query.getSingleResult();
			
			
			
			session.getTransaction().commit();
			
			session.close();
			System.out.println("SESSION IS CLOSED");
			System.out.println(instructor.getCourses());
			System.out.println(instructor.getInstructorDetail());
		}
		
		catch(Exception exception) {
			exception.printStackTrace();
		}
		
		finally {
			session.close();
			sessionFactory.close();
		}

	}

}
