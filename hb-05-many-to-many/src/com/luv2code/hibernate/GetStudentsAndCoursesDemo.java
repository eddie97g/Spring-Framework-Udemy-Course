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
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetStudentsAndCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			

			session.beginTransaction();

			Student student1 = session.get(Student.class, 3);
			Student student2 = session.get(Student.class, 4);
			
			Course course1 = session.get(Course.class, 11);
			Course course2 = session.get(Course.class, 12);
			Course course3 = session.get(Course.class, 10);
			System.out.println("---------------------------------------------------------");
			System.out.println("Students in Engineering Ethics: " + course3.getStudents());
			System.out.println("---------------------------------------------------------");
			System.out.println("Students in Algorithms: " + course1.getStudents());
			System.out.println("---------------------------------------------------------");
			System.out.println("Students in Data Structures: " + course2.getStudents());
			System.out.println("---------------------------------------------------------");
			System.out.println("---------------------------------------------------------");
			System.out.println("Courses that Eddie is enrolled in: " + student1.getCourses());
			System.out.println("---------------------------------------------------------");
			System.out.println("Courses that Esmie is enrolled in: " + student2.getCourses());
			System.out.println("---------------------------------------------------------");
			
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
