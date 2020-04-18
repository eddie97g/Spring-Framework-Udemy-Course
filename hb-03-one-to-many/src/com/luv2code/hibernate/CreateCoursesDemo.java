package com.luv2code.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			
			
//			List<Course> courses = new ArrayList<>(Arrays.asList(new Course("Algorithms"),
//					new Course("Data Structures"),
//					new Course("Senior Capstone Project")));
			
			Course course1 = new Course("Algorithms");
			Course course2 = new Course("Data Structures");
			Course course3 = new Course("Senior Capstone Project");
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			instructor.addCourse(course3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			session.getTransaction().commit();
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
