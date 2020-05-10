package com.luv2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student student1 = new Student("Paul", "Wall", "paul@yahoo.com");
			Student student2 = new Student("Kobe", "Bryant", "kobe@yahoo.com");
			Student student3 = new Student("Michael", "Jordan", "mj@yahoo.com");

			session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
		}

		catch (Exception exception) {
			exception.printStackTrace();
		}

		finally {
			sessionFactory.close();
		}

	}

}
